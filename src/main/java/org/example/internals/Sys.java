package org.example.internals;

import java.awt.AWTException;
import java.awt.Image;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.util.List;
import oshi.SystemInfo;
import oshi.hardware.HWDiskStore;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.hardware.PowerSource;

/**
 * Utility class for system-related operations.
 * Provides methods for printing colored console messages, accessing
 * system properties, retrieving hardware information, clipboard operations,
 * online status check, and desktop notifications.
 */

public class Sys {

  private static final SystemInfo si = new SystemInfo();
  private static final HardwareAbstractionLayer hal = si.getHardware();
  private static String clipBoardContent;

  /**
   * Private constructor: No instantiation, bro.
   */
  private Sys() {}

  /**
   * Prints a debug message in blue color to the console.
   *
   * @param message the message to print
   */
  public static void printDebug(String message) {
    java.lang.System.out.println("\u001B[34m" + message + "\u001B[0m");
  }

  /**
   * Prints a warning message in yellow color to the console.
   *
   * @param message the message to print
   */
  public static void printWarning(String message) {
    java.lang.System.out.println("\u001B[33m" + message + "\u001B[0m");
  }

  /**
   * Prints an error message to the standard error output.
   *
   * @param message the message to print
   */
  public static void printError(String message) {
    java.lang.System.err.println(message);
  }

  /**
   * Copies a string to the system clipboard and stores it internally.
   *
   * @param string the string to copy
   */
  public static void copyToClipBoard(String string) {
    Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
    StringSelection selection = new StringSelection(string);
    clipboard.setContents(selection, null);
    clipBoardContent = string;
  }

  /**
   * Returns the last string copied to the clipboard as a MarsikString.
   *
   * @return the clipboard content
   */
  public static String getClipBoardContent() {
    return clipBoardContent;
  }

  /**
   * Returns the operating system name in lowercase.
   *
   * @return OS name
   */
  public static String getOs() {
    return System.getProperty("os.name").toLowerCase();
  }

  /**
   * Returns the operating system version in lowercase.
   *
   * @return OS version
   */
  public static String getOsVersion() {
    return System.getProperty("os.version").toLowerCase();
  }

  /**
   * Returns the username of the current user in lowercase.
   *
   * @return username
   */
  public static String getUserName() {
    return System.getProperty("user.name").toLowerCase();
  }

  /**
   * Returns the number of physical CPU cores as a String.
   *
   * @return number of cores
   */
  public static String getNumberOfCores() {
    return String.valueOf(hal.getProcessor().getPhysicalProcessorCount());
  }

  /**
   * Returns the total RAM in gigabytes.
   *
   * @return total RAM in GB
   */
  public static long getTotalRamInGb() {
    return hal.getMemory().getTotal() / 1_000_000_000;
  }

  /**
   * Returns the available RAM in gigabytes.
   *
   * @return available RAM in GB
   */
  public static long getAvailableRamInGb() {
    return hal.getMemory().getAvailable() / 1_000_000_000;
  }

  /**
   * Returns the current CPU temperature as a String.
   *
   * @return CPU temperature
   */
  public static String getCpuTemperature() {
    return hal.getSensors().getCpuTemperature() + " °C";
  }

  /**
   * Returns the current CPU voltage as a String.
   *
   * @return CPU voltage
   */
  public static String getCpuVoltage() {
    return hal.getSensors().getCpuVoltage() + " V";
  }

  /**
   * Returns information about all power sources (e.g., batteries).
   *
   * @return power sources info
   */
  public static String getPowerSourcesInfo() {
    StringBuilder powerSources = new StringBuilder();
    for (PowerSource powerSource : hal.getPowerSources()) {
      powerSources.append("Battery: ").append(powerSource.getName()).append(", Remaining: ")
              .append(powerSource.getCurrentCapacity() * 100).append("% \n");
    }
    return powerSources.toString();
  }

  /**
   * Returns information about all disks (model and size).
   *
   * @return disks info
   */
  public static String getDisksInfo() {
    StringBuilder disksInfo = new StringBuilder();
    List<HWDiskStore> disks = hal.getDiskStores();
    for (HWDiskStore disk : disks) {
      disksInfo.append("Model: ").append(disk.getName())
              .append(", Size: ").append(disk.getSize() / 1_000_000_000).append(" GB");
    }
    return disksInfo.toString();
  }

  /**
   * Checks whether the system is online by attempting to connect to Google.
   *
   * @return true if online, false otherwise
   */
  public static boolean isOnline() {
    try {
      java.net.HttpURLConnection connection = (java.net.HttpURLConnection) new java.net.URL("https://www.google.com").openConnection();
      connection.setConnectTimeout(2000);
      connection.connect();
      return connection.getResponseCode() == 200;
    } catch (Exception e) {
      return false;
    }
  }

  /**
   * Shows a system notification with a custom icon and message type.
   *
   * @param title       notification title
   * @param message     notification message
   * @param iconPath    path to the notification icon
   * @param messageType type of message (INFO, WARNING, ERROR)
   */
  public static void showSystemNotification(String title, String message,
                                            String iconPath, String messageType) {
    try {
      TrayIcon trayIcon = setTrayIcon(iconPath);
      TrayIcon.MessageType messageTypeIcon = TrayIcon.MessageType.valueOf(messageType);
      trayIcon.displayMessage(title, message, messageTypeIcon);
    } catch (AWTException e) {
      Sys.printError("An Error occurred while setting up Notification: " + e.getMessage());
    }
  }

  /**
   * Sets up a TrayIcon for system notifications.
   *
   * @param iconPath path to the icon image
   * @return the TrayIcon object
   * @throws AWTException                  if the system tray is unavailable
   * @throws UnsupportedOperationException if system notifications are not supported
   */
  private static TrayIcon setTrayIcon(String iconPath) throws AWTException {
    if (!SystemTray.isSupported()) {
      throw new UnsupportedOperationException("System notification are not supported on your OS");
    }
    SystemTray tray = SystemTray.getSystemTray();
    Image image = Toolkit.getDefaultToolkit().createImage(iconPath);
    TrayIcon trayIcon = new TrayIcon(image, "Notification");
    trayIcon.setImageAutoSize(true);
    trayIcon.setToolTip("Tooltip-text");
    tray.add(trayIcon);
    return trayIcon;
  }
}
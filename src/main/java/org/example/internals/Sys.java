package org.example.internals;

import oshi.SystemInfo;
import oshi.hardware.HWDiskStore;
import oshi.hardware.HardwareAbstractionLayer;
import oshi.hardware.PowerSource;
import java.awt.AWTException;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.Image;
import java.awt.SystemTray;
import java.awt.Toolkit;
import java.awt.TrayIcon;
import java.util.List;

public class Sys {

  private static final SystemInfo si = new SystemInfo();
  private static final HardwareAbstractionLayer hal = si.getHardware();
  private static String clipBoardContent;

  private Sys() {
    // No instantiation, or you catch a fade.
  }

  public static void printDebug(String message) {
    java.lang.System.out.println("\u001B[34m" + message + "\u001B[0m");
  }

  public static void printWarning(String message) {
    java.lang.System.out.println("\u001B[33m" + message + "\u001B[0m");
  }

  public static void printError(String message) {
    java.lang.System.err.println(message);
  }

  public static void copyToClipBoard(String string) {
    Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
    StringSelection selection = new StringSelection(string);
    clipboard.setContents(selection, null);
    clipBoardContent = string;
  }

  public static String getClipBoardContent() {
    return clipBoardContent;
  }

  public static String getOs() {
    return java.lang.System.getProperty("os.name").toLowerCase();
  }

  public static String getOsVersion() {
    return java.lang.System.getProperty("os.version").toLowerCase();
  }

  public static String getUserName() {
    return java.lang.System.getProperty("user.name").toLowerCase();
  }

  public static String getNumberOfCores() {
    return String.valueOf(hal.getProcessor().getPhysicalProcessorCount());
  }

  public static long getTotalRamInGB() {
    return hal.getMemory().getTotal() / 1_000_000_000;
  }

  public static long getAvailableRamInGB() {
    return hal.getMemory().getAvailable() / 1_000_000_000;
  }

  public static String getCpuTemperature() {
    return hal.getSensors().getCpuTemperature() + " °C";
  }

  public static String getCpuVoltage() {
    return hal.getSensors().getCpuVoltage() + " V";
  }

  public static String[] getPowerSourcesInfo() {
    String[] powerSources = new String[hal.getPowerSources().size()];
    List<PowerSource> powerSourceList = hal.getPowerSources();
    for (int i = 0; i < powerSourceList.size(); i++) {
      powerSources[i] = "Battery: " + powerSourceList.get(i).getName()
              + ", Remaining: " + (powerSourceList.get(i).getCurrentCapacity() * 100)
              + "%";
    }
    return powerSources;
  }

  public static String[] getDisksInfo() {
    String[] disksInfos = new String[hal.getDiskStores().size()];
    List<HWDiskStore> disks = hal.getDiskStores();
    for (int i = 0; i < disks.size(); i++) {
      disksInfos[i] = "Model: " + disks.get(i).getName()
              + ", Size: " + (disks.get(i).getSize() / 1_000_000_000 + " GB");
    }
    return disksInfos;
  }

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

  private static void showSystemNotification(String title, String message, String iconPath, TrayIcon.MessageType messageType) {
    try {
      TrayIcon trayIcon = setTrayIcon(iconPath);
      trayIcon.displayMessage(title, message, messageType);
    } catch (AWTException e) {
      Sys.printError("An Error occurred while setting up Notification: " + e.getMessage());
    }
  }

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
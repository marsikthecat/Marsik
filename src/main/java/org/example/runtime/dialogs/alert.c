#include "alert.h"
#include "tinyfiledialogs.h"
#include "../string.h"

struct Alert init_alert() {
  struct Alert a;
  a.header = NULL;
  a.message = NULL;
  a.mode = "info";
  a.icon = NULL;
  return a;
}

void alert_setHeader(struct Alert* alert, string* header) {
  alert->header = (string)header;
}

void alert_setMessage(struct Alert* alert, string* message) {
  alert->message = (string)message;
}

void alert_setMode(struct Alert* alert, string* mode) {
  alert->mode = (string)mode;
}

void alert_setIcon(struct Alert* alert, string* icon) {
  alert->icon = (string)icon;
}

void alert_show(struct Alert* alert) {
  tinyfd_messageBox(alert->header, alert->message, "ok", alert->icon, 0);
}

char* alert_showInput(struct Alert* alert, string* title) {
  return tinyfd_inputBox((string)title, alert->message, NULL);
}

int alert_showConfirm(struct Alert* alert, string* title) {
  return tinyfd_messageBox((string)title, alert->message, "yesno", alert->icon, 1);
}
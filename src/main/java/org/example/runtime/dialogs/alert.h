#ifndef ALERT_H
#define ALERT_H

#include <stdlib.h>
#include <stdbool.h>
#include "../string.h"

struct Alert {
  string header;
  string message;
  string mode;
  string icon;
};

struct Alert init_alert();
void alert_setHeader(struct Alert* alert, void* header);
void alert_setMessage(struct Alert* alert, void* message);
void alert_setMode(struct Alert* alert, void* mode);
void alert_setIcon(struct Alert* alert, void* icon);
void alert_show(struct Alert* alert);
char* alert_showInput(struct Alert* alert, void* title);
int alert_showConfirm(struct Alert* alert, void* title);

#endif
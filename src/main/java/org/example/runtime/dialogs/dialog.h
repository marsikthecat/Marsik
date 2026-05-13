#ifndef DIALOG_H
#define DIALOG_H

#include <stdlib.h>
#include <stdbool.h>
#include "../string.h"

struct Dialog {
  string title;
  string header;
  string message;
};

struct Dialog init_dialog();
void dialog_setTitle(struct Dialog* dialog, void* title);
void dialog_setHeader(struct Dialog* dialog, void* header);
void dialog_setMessage(struct Dialog* dialog, void* message);
string dialog_showInput(struct Dialog* dialog);
int dialog_showConfirm(struct Dialog* dialog);

#endif
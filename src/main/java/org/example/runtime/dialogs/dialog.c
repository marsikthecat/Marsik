#include "dialog.h"
#include "../tinyfiledialogs/tinyfiledialogs.h"

struct Dialog init_dialog() {
  struct Dialog d;
  d.title = NULL;
  d.header = NULL;
  d.message = NULL;
  return d;
}

void dialog_setTitle(struct Dialog* dialog, void* title) {
  dialog->title = (string)title;
}

void dialog_setHeader(struct Dialog* dialog, void* header) {
  dialog->header = (string)header;
}

void dialog_setMessage(struct Dialog* dialog, void* message) {
  dialog->message = (string)message;
}

string dialog_showInput(struct Dialog* dialog) {
  return tinyfd_inputBox(dialog->title, dialog->message, NULL);
}

int dialog_showConfirm(struct Dialog* dialog) {
  return tinyfd_messageBox(dialog->title, dialog->message, "yesno", dialog->header, 1);
}
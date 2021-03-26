package errors;

import errors.messages.FieldHasInvalidLength;
import errors.messages.FieldIsEmptyMessage;
import errors.messages.Message;

import static config.ValidationConfig.*;


public enum GuiError {
    USERNAME_IS_EMPTY(new FieldIsEmptyMessage("Username")),
    USERNAME_HAS_INVALID_LENGTH(new FieldHasInvalidLength("Username", USERNAME_MIN_LENGTH, USERNAME_MAX_LENGTH)),
    PASSWORD_IS_EMPTY(new FieldIsEmptyMessage("Password")),
    PASSWORD_HAS_INVALID_LENGTH(new FieldHasInvalidLength("Password", PASSWORD_MIN_LENGTH, PASSWORD_MAX_LENGTH));

    private final Message MESSAGE;

    GuiError(Message message) {
        this.MESSAGE = message;
    }

    public String getMessage() {
        return MESSAGE.getValue();
    }
}

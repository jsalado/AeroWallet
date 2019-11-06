package com.samsung.aero_wallet_app.view;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.util.Linkify;
import android.widget.TextView;

import com.samsung.aero_wallet_app.R;

public class AlertUtil {

    private AlertUtil() {
    }

    public static void showAlertDialog(Activity activity, String message) {
        AlertDialog.Builder alertBuilder = new AlertDialog.Builder(activity);
        alertBuilder.setMessage(message);
        alertBuilder.setPositiveButton(R.string.close, (dialogInterface, i) -> {
            dialogInterface.dismiss();
        });
        alertBuilder.show();
    }

    public static void showActivityCloseAlertDialog(Activity activity, String message, boolean closeActivityOnDismiss) {
        AlertDialog.Builder alertBuilder = new AlertDialog.Builder(activity);
        alertBuilder.setMessage(message);
        alertBuilder.setPositiveButton(R.string.close, (dialogInterface, i) -> {
            activity.finish();
        });
        if (closeActivityOnDismiss) {
            alertBuilder.setOnDismissListener(dialogInterface -> {
                activity.finish();
            });
        }
        alertBuilder.show();
    }

    // JS Added this method to show a dialog with a clickable link in the message
    public static void showActivityCloseAlertDialogWithLink(Activity activity, String message, boolean closeActivityOnDismiss) {
        final SpannableString str = new SpannableString(message);
        Linkify.addLinks(str, Linkify.ALL);

        AlertDialog.Builder alertBuilder = new AlertDialog.Builder(activity);
        alertBuilder.setMessage(str);
        alertBuilder.setPositiveButton(R.string.close, (dialogInterface, i) -> {
            activity.finish();
        });
        if (closeActivityOnDismiss) {
            alertBuilder.setOnDismissListener(dialogInterface -> {
                activity.finish();
            });
        }
        AlertDialog alert = alertBuilder.create();
        alert.show();
        ((TextView)alert.findViewById(android.R.id.message)).setMovementMethod(LinkMovementMethod.getInstance());
    }

    public static void showConfirmationAlertDialog(Activity activity, String message,
                                                   int positiveButtonMessage, DialogInterface.OnClickListener positiveActionListener,
                                                   int negativeButtonMessage, DialogInterface.OnClickListener negativeActionListener) {
        AlertDialog.Builder alertBuilder = new AlertDialog.Builder(activity);
        alertBuilder.setMessage(message);
        alertBuilder.setPositiveButton(positiveButtonMessage, positiveActionListener);
        alertBuilder.setNegativeButton(negativeButtonMessage, negativeActionListener);
        alertBuilder.show();
    }
}

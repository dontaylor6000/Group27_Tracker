package tracker.backgroundsvc;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;

public class Email extends Activity {
    public void sendEmail(String userEmail, String userName, String trackerName) {
        Intent emailIntent = new Intent(Intent.ACTION_SEND);

        emailIntent.setDataAndType(Uri.parse(userEmail), "text/plain");
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Tracker " + trackerName + " : Battery Warning");
        emailIntent.putExtra(Intent.EXTRA_TEXT, userName + ",\n Battery power for Tracker " +
                trackerName + " is below recommended levels. To ensure continued operation " +
                "please recharge the battery for the Tracker at your earliest convenience.");
        try {
            startActivity(Intent.createChooser(emailIntent, "Sending"));
            finish();
        } catch (android.content.ActivityNotFoundException ex) {
            //Do something with error case
        }
    }
}

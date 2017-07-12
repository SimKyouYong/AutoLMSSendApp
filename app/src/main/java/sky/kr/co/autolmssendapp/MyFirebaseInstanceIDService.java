package sky.kr.co.autolmssendapp;

import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

import sky.kr.co.autolmssendapp.common.CommonUtil;

public class MyFirebaseInstanceIDService extends FirebaseInstanceIdService {
    CommonUtil dataSet = CommonUtil.getInstance();

    private static final String TAG = "MyFirebaseIIDService";

    // [START refresh_token]
    @Override
    public void onTokenRefresh() {
        // Get updated InstanceID token.
        String token = FirebaseInstanceId.getInstance().getToken();
        Log.d(TAG, "Refreshed token: " + token);

        dataSet.REG_ID = token;
    }

}
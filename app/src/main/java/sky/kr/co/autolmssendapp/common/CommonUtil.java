package sky.kr.co.autolmssendapp.common;

import android.annotation.SuppressLint;
import android.app.Activity;

import java.util.ArrayList;
import java.util.StringTokenizer;


//AIzaSyApdCPSYnLhdlNMqQGJ3sJnFwUqIkWgKpY
@SuppressLint("SdCardPath")
public class CommonUtil {
	private static CommonUtil _instance;
	public static boolean isHome = false;
	public static boolean isLock = false;

	public int EA;
	public int HomeBtn;
	
	public ArrayList<Activity> av = new ArrayList<Activity>();					//Activity 를 담는다.

	public String PHONE;
    public String SERVER;
    public String REG_ID;



	

	static {
		_instance = new CommonUtil();
		try {								 
			_instance.REG_ID = 	   		"";
			_instance.PHONE = 	   		"";
			_instance.SERVER = 	   		"http://snap40.cafe24.com/AutoLms/";

			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static CommonUtil getInstance() {
		return _instance;
	}

	
	public ArrayList<String> Token_String(String url , String token){
		ArrayList<String> Obj = new ArrayList<String>();

		StringTokenizer st1 = new StringTokenizer( url , token);
		while(st1.hasMoreTokens()){
			Obj.add(st1.nextToken());
		}
		return Obj;
	}
}

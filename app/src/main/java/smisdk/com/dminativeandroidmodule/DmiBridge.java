package smisdk.com.dminativeandroidmodule;

import android.content.Context;

import com.datami.smi.SmiSdk;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

/**
 * Created by avi_chopra on 02/04/18.
 */

public class DmiBridge extends ReactContextBaseJavaModule {

    Context context;

    public DmiBridge(ReactApplicationContext reactApplicationContext){
        super(reactApplicationContext);
        context = reactApplicationContext;
    }

    @ReactMethod
    public void initialiseDatami(String apiKey){
        SmiSdk.initSponsoredData(apiKey, context, "", -1, false);
    }

    @Override
    public String getName() {
        return "DmiBridge";
    }
}

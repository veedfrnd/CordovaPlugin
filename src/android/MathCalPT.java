package cordova.plugin.ptmath;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import javafx.util.Callback;

/**
 * This class echoes a string called from JavaScript.
 */
public class MathCalPT extends CordovaPlugin {

    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (action.equals("add")) {
            this.add(args, callbackContext);
            return true;
        }
        return false;
    }

    private void add(JSONArray args, CallbackContext callbkContext) {
        if (args != null) {
            try {
                int p1 = Integer.parseInt(args.getJSONObject(0).getString("param1"));
                int p2 = Integer.parseInt(args.getJSONObject(0).getString("param2"));
                callbkContext.success("" + (p1 + p2));
            } catch (Exception e) {
                callbkContext.error("Something wentwrong " + e.getMessage());
            }
        } else {
            callbkContext.error("Null value");
        }
    }
}

package ciecc.swzf.common.util;

import net.sf.json.JSONArray;

import java.util.HashMap;
import java.util.Map;

public class JsonMsgUtils {

	/**
	 * 返回json信息
	 * @param state 上传状态“true”/“false”
	 * @param msg 备注信息
	 * @return
	 */
	public static String returnJsonMsg(String state, String msg) {
		Map<String, String> map = new HashMap<>();
		map.put("msg", msg);
		map.put("state", state);
		return JSONArray.fromObject(map).toString();
	}

}

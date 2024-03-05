package com.higradius;

import java.util.ArrayList;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;

public class ArrayListToJson {
	public static void main(String[] args)
	{
		JsonArray ar = conv();
		System.out.println(ar);
	}
	static JsonArray conv()
	{
		Gson gson = new GsonBuilder().create();
		ArrayList<pojo> all = GetDataArray.getAll();
		JsonArray jsonArray = gson.toJsonTree(all).getAsJsonArray();
		return jsonArray;
	}
}

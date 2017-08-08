package com.itworks.simulatelottery;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.google.gson.Gson;
import com.itworks.simulatelottery.volley.CacheUtils;
import com.itworks.simulatelottery.volley.VolleyManager;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class MainActivity extends Activity {


    private Button tvResult;
    private int allcount;
    private ArrayList<int[]> positionList;
    private ArrayList<int[]> numList;
    private ArrayList<int[]> templepositionList;
    private ArrayList<int[]> templepositionMoreList;
    private ArrayList<int[]> templenumList;
    private ArrayList<MyBean.ListBean> allLists;
    private ArrayList<Integer> numLists;
    //begin
    private int BLANK_INT = 3;
    private EditText et_blank;
    private int BLANK_COUNT = 0;
    private ArrayList<int[]> allcountList;
    private ArrayList<int[]> lastSizeList;
    private ArrayList<int[]> blankCountList;
    private ArrayList<int[]> buyPositonList;
    private int CURRENT_BLANK;
    private int END_BLANK = 200;
    private int BUY_AMOUNT = 15;
    private EditText et_endBlank;
    private EditText et_length;
    private int LENGTH = 2000;
    private int SIZE = 1;

    private int LESS_AMOUNT = 0;
    private int ALI_LESS_AMOUNT = 0;
    private int ALI_MORE_AMOUNT = 0;
    private int ALL_AMOUNT = 0;
    private int END_BUY = 0;
    private EditText et_size;
    private HashMap<Integer, Integer> buyPositionMap;
    private HashMap<Integer, Integer> buyNumMap;
    private HashMap<Integer, Integer> trueMap;
    private HashMap<Integer, Integer> lastPositionMap;
    private HashMap<Integer, Integer> lastNumMap;
    private int LAST_TREM = -1;

    //bigger
    private int MAX_2 = 7;
    private int BLANK_2 = 15;

    private int count = 0;
    private EditText et_endBuy;
    private Button btn_two;
    private EditText et_max2Int;
    private EditText et_less_blank;
    private int buyCount;
    private int difbuyCount;
    private int biggercount;
    private int lastCount;
    private int lastdifCount;

    private int position1 = 1;
    private int position2 = 2;
    private int sameSize = 3;
    private double difNUm = 0;
    private String difBuyStr;
    private String difLastBuyEarnStr;

    private String myurlxyft = "http://api.kaijiangtong.com/lottery/?name=xyft&format=json2&uid=533810&token=8ecc79c616cc9475d246369db1165d9466df61e7&date=";
    private String myurlpk10 = "http://api.kaijiangtong.com/lottery/?name=bjpks&format=json2&uid=533810&token=8ecc79c616cc9475d246369db1165d9466df61e7&date=";
    private String Url;
    private ArrayList<String> urlsList;

    private int year = 2017;
    private int month=8;
    private int day = 5;
    private String refreshUrl;
    private int index = 0;
    int urlNum = 5;
    private EditText et_date;
    private EditText et_urlnum;
    private Button btn_change;
    private EditText et_bigbegin;
    private int Bint = 45;
    private int BiggerInt = 35;

    private String type = "SC";
    private boolean IS_SC = true;
    private int[] earnPositionArray;
    private int[] buyPositionArray;


    private void initBaseData() {

        if (null == allLists) {
            allLists = new ArrayList<MyBean.ListBean>();

            lastSizeList = initList(-1);
//            allcountList = initList(0);
            blankCountList = initList(0);
            buyPositonList = initList(-1);
        }
        earnPositionArray = new int[110];
        buyPositionArray = new int[110];

        for (int i = 0; i < 110; i++) {
            earnPositionArray[i] = 0;
            buyPositionArray[i] = 0;
        }

        if (null == buyPositionMap) {
            buyPositionMap = new HashMap<Integer, Integer>();
            buyNumMap = new HashMap<Integer, Integer>();
            trueMap = new HashMap<Integer, Integer>();
            lastPositionMap = new HashMap<Integer, Integer>();
            lastNumMap = new HashMap<Integer, Integer>();
            numLists = new ArrayList<Integer>();
            resetBuyMap();
        }
        lastPositionMap.clear();

        if (null == positionList) {
            positionList = initList(0);
        } else {
            positionList.clear();
            positionList = initList(0);
        }
        if (null == numList) {
            numList = initList(0);
        } else {
            numList.clear();
            numList = initList(0);
        }
        if (null == templepositionList) {
            templepositionList = initList(0);
        } else {
            templepositionList.clear();
            templepositionList = initList(0);
        }
        if (null == templepositionMoreList) {
            templepositionMoreList = initList(0);
        } else {
            templepositionMoreList.clear();
            templepositionMoreList = initList(0);
        }
        if (null == templenumList) {
            templenumList = initList(0);
        } else {
            templenumList.clear();
            templenumList = initList(0);
        }
    }

    private void resetBuyMap() {

        for (int i = 0; i <10; i++) {
            for (int j = 0; j < 10; j++) {
                buyPositionMap.put(i * 10 + j, -1);
                buyNumMap.put(i * 10 + j, -1);
            }

        }
        for (int i = 0; i <10; i++) {
            for (int j = 0; j < 10; j++) {
                trueMap.put(i * 10 + j, -1);
            }

        }
    }

    private ArrayList<int[]> initList(int val) {
        ArrayList<int[]> list = new ArrayList<int[]>();
        for (int i = 0; i < 10; i++) {
            int[] ints = new int[10];
            for (int j = 0; j < 10; j++) {
                ints[j] = val;
            }
            list.add(ints);
        }
        return list;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvResult = (Button) findViewById(R.id.tvResult);
        et_blank = (EditText) findViewById(R.id.et_blank);
        et_endBlank = (EditText) findViewById(R.id.et_endBlank);
        et_length = (EditText) findViewById(R.id.et_length);
        et_size = (EditText) findViewById(R.id.et_size);
        et_endBuy = (EditText) findViewById(R.id.et_endBuy);
        et_max2Int = (EditText) findViewById(R.id.et_max2Int);
        et_less_blank = (EditText) findViewById(R.id.et_less_blank);
        et_bigbegin = (EditText) findViewById(R.id.et_bigbegin);

        et_date = (EditText) findViewById(R.id.et_date);
        et_urlnum = (EditText) findViewById(R.id.et_urlnum);
        btn_two = (Button) findViewById(R.id.btn_two);
        btn_change = (Button) findViewById(R.id.btn_change);
        btn_change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (IS_SC) {
                    type = "FT";
                    IS_SC = false;
                    btn_change.setText("FT");
                } else {
                    type = "SC";
                    IS_SC = true;
                    btn_change.setText("SC");
                }
            }
        });

        tvResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        getLotteryResult();
                    }
                }).start();
            }
        });
        btn_two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        getLotteryResult();
                    }
                }).start();
            }
        });

    }

    @Override
    protected void onPause() {
        super.onPause();

    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    private void getLotteryResult() {
//        allcount = 0;
        ALL_AMOUNT = 0;
        index = 0;
        buyPositonList = initList(-1);
        String blank = et_blank.getText().toString();
        String endBlank = et_endBlank.getText().toString();
        String length = et_length.getText().toString();
        String size = et_size.getText().toString();
        String endbuy = et_endBuy.getText().toString();
        String max2int = et_max2Int.getText().toString();
        String lessBlank = et_less_blank.getText().toString();
        String urlNums = et_urlnum.getText().toString();
        String date = et_date.getText().toString();
        String bigger = et_bigbegin.getText().toString();
        if (!TextUtils.isEmpty(date)) {
            String[] split = date.split("-");
            year = Integer.parseInt(split[0]);
            month = Integer.parseInt(split[1]);
            day = Integer.parseInt(split[2]);
        }
        if (!TextUtils.isEmpty(bigger)) {
            BiggerInt = Integer.parseInt(bigger);
        }
        if (!TextUtils.isEmpty(urlNums)) {
            urlNum = Integer.parseInt(urlNums);
        }
        if (!TextUtils.isEmpty(max2int)) {
            MAX_2 = Integer.parseInt(max2int);
        }
        if (!TextUtils.isEmpty(lessBlank)) {
            BLANK_2 = Integer.parseInt(lessBlank);
        }
        if (!TextUtils.isEmpty(endbuy)) {
            END_BUY = Integer.parseInt(endbuy);
        }
        if (!TextUtils.isEmpty(blank)) {
            BLANK_INT = Integer.parseInt(blank);
        }
        if (!TextUtils.isEmpty(endBlank)) {
            difNUm = Integer.parseInt(endBlank);
        }
        if (!TextUtils.isEmpty(length)) {
            LENGTH = Integer.parseInt(length);
        }
        if (!TextUtils.isEmpty(size)) {
            SIZE = Integer.parseInt(size);
        }

        Log.e("BLANK_INT", "BLANK_INT: " + BLANK_INT);
        Log.e("BLANK_INT", "END_BLANK: " + END_BLANK);
        Log.e("BLANK_INT", "LENGTH: " + LENGTH);
        Log.e("BLANK_INT", "BUY_AMOUNT: " + BUY_AMOUNT);
        Log.e("BLANK_INT", "SIZE: " + SIZE);

        initBaseData();

        for (int m = 0; m < SIZE; m++) {

            BUY_AMOUNT = 0;
            LESS_AMOUNT = 0;
            count = 0;
            allLists.clear();
            initUrls();
            if (null == allcountList) {
                allcountList = initList(0);
            } else {
                allcountList.clear();
                allcountList = initList(0);
            }
            getDataFromNet();

        }




    }


    private void initUrls() {
        urlsList = new ArrayList<String>();

        for (int i = 1; i <= urlNum; i++) {
            if ((day - i) <= 0) {
                urlsList.add(lashMoth(day - i));

            }
            if (month < 10) {
                if ((day - i) < 10 && (day - i) > 0) {
                    refreshUrl = Url + year + "0" + month + "0" + (day - i) + "";
                    urlsList.add(refreshUrl);
                }
                if ((day - i) >= 10) {

                    refreshUrl = Url + year + "0" + month + (day - i) + "";
                    urlsList.add(refreshUrl);
                }
            } else {
                if ((day - i) < 10 && (day - i) > 0) {
                    refreshUrl = Url + year + month + "0" + (day - i) + "";
                    urlsList.add(refreshUrl);
                }
                if ((day - i) >= 10) {

                    refreshUrl = Url + year + month + (day - i) + "";
                    urlsList.add(refreshUrl);
                }

            }
        }
    }



    private String lashMoth(int daycount) {

        int maxDay;
        if ((month - 1) == 0) {
            maxDay = new Date(year - 1, 12, 0).getDate();
        }
        maxDay = new Date(year, month - 1, 0).getDate();
        if (month == 1) {
//            return Url + (year - 1) + "12" + (maxDay + daycount) + "";

            if ((maxDay + daycount) >= 10) {
                return Url + (year - 1) + "12" + (maxDay + daycount) + "";
            } else {
                return Url + (year - 1) + "12" + "0" + (maxDay + daycount) + "";
            }
        } else {
            if ((month - 1) < 10) {
                if ((maxDay + daycount) > 10) {
                    return Url + year + "0" + (month - 1) + (maxDay + daycount) + "";
                } else {
                    return Url + year + "0" + (month - 1) + "0" + (maxDay + daycount) + "";
                }
            } else {

                if ((maxDay + daycount) >= 10) {
                    return Url + year + (month - 1) + (maxDay + daycount) + "";
                } else {
                    return Url + year + (month - 1) + "0" + (maxDay + daycount) + "";
                }

            }
        }
    }

    private void afterNet() {
//        for (int j = 0; j < 200 + LENGTH; j++) {
//            ArrayList<Integer> integers = new ArrayList<Integer>();
//            Set<Integer> resultSet = generateRandomArray(10);
//            Iterator<Integer> it = resultSet.iterator();
//
//            //result
//            while (it.hasNext()) {
//                integers.add(it.next());
//            }
//            allLists.add(0, integers);
//        }


        for (int i = allLists.size(); i >= 200; i--) {
            difbuyCount = 0;
            biggercount = 0;
            if (i <= (allLists.size() - BLANK_INT)) {
                resetBuyMap();
                for (int j = BLANK_INT; j < END_BLANK; j++) {
                    getNumBlankData(i, j);
                }
//                    get2PostionBuyMap(i);
                LAST_TREM = i;
//                    setLastMap(i);
            }
            getDifPositionBuyMap(i);
            lastdifCount = difbuyCount;
            getProgress(i);
        }

        if (ALI_LESS_AMOUNT > LESS_AMOUNT) {
            ALI_LESS_AMOUNT = LESS_AMOUNT;
        }
        if (ALI_MORE_AMOUNT < BUY_AMOUNT) {
            ALI_MORE_AMOUNT = BUY_AMOUNT;
        }
        ALL_AMOUNT = ALL_AMOUNT + BUY_AMOUNT;
        Log.e("", "LESS_AMOUNT: " + LESS_AMOUNT + ",ALI_LESS_AMOUNT:" + ALI_LESS_AMOUNT + ",ALI_MORE_AMOUNT:" + ALI_MORE_AMOUNT + ",ALL_AMOUNT:" + ALL_AMOUNT + ",BUY_AMOUNT:" + BUY_AMOUNT + ",count:" + count);
        String endResult = "";
        String buyResult = "";
        for (int i = 0; i < earnPositionArray.length; i++) {
            if (earnPositionArray[i] != 0) {
                endResult = endResult + i + ":" + earnPositionArray[i] + "~~~~~~~~~~~~~";
            }
            if (buyPositionArray[i] != 0) {
                buyResult = buyResult + i + ":" + buyPositionArray[i] + "~~~~~~~~~~~~~";
            }
        }
        Log.e("end", "endresultBUY_AMOUNT: " + endResult);
        Log.e("end", "buyResultBUY_AMOUNT: " + buyResult);
    }

    private void getDataFromNet() {

        if (IS_SC) {
            Url = myurlpk10;
        } else {
            Url = myurlxyft;
        }
        String cache = CacheUtils.getCache(this, type + urlsList.get(index));
        if (!TextUtils.isEmpty(cache)) {
            gsonParse(cache);
            index++;
            if (index < urlNum) {
                getDataFromNet();
            } else {
                afterNet();
            }
        } else {

            VolleyManager.newInstance().StrRequest("TAG", Request.Method.GET, urlsList.get(index), new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    CacheUtils.putCache(MainActivity.this, type + urlsList.get(index), response);
                    gsonParse(response);
                    index++;
                    Toast.makeText(MainActivity.this, "成功：" + index, Toast.LENGTH_SHORT).show();

                    try {
                        Thread.sleep(1000);
                        if (index < urlNum) {
                            getDataFromNet();
                        } else {
                            afterNet();
                        }

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }


                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
//                getDataFromNet();
                    Toast.makeText(MainActivity.this, "失败", Toast.LENGTH_SHORT).show();
                }
            });
        }

    }

    private void afterGetData() {

    }

    private void gsonParse(String result) {

        Gson gson = new Gson();
        MyBean pcOriginBean = gson.fromJson(result, MyBean.class);
        allLists.addAll(pcOriginBean.getList());
    }


    private void getDifPositionBuyMap(int term) {
        difLastBuyEarnStr = "";
//        if (difbuyCount > difNUm) {
//            BUY_AMOUNT = BUY_AMOUNT - 10 * difbuyCount;
//            Log.e("BUY_AMOUNT", "BUY_AMOUNT: " + BUY_AMOUNT + "-trem:" + allLists.get(term).getCTerm() + "-difbuyCount:" + difbuyCount);
//        }

        if (lastdifCount > 0) {
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {

                    if (lastPositionMap.size() > 0 && -1 != lastPositionMap.get(i * 10 + j) && -1 == trueMap.get(i * 10 + j) && lastPositionMap.get(i * 10 + j) <= MAX_2) {
                        BUY_AMOUNT = BUY_AMOUNT + 99;
                        difLastBuyEarnStr = difLastBuyEarnStr + "\n" + "位置:" + (i * 10 + j) + ",blank:" + lastPositionMap.get(i * 10 + j);
                        earnPositionArray[lastPositionMap.get(i * 10 + j)]++;
                        Log.e("BUY_AMOUNT", "BUY_AMOUNT_EARN~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~: " + BUY_AMOUNT + "-trem:" + allLists.get(term).getCTerm() + "-lastdifCount:" + lastdifCount + "-blank:" + lastPositionMap.get(i * 10 + j));
                    }

                }

            }
        }

        if (!TextUtils.isEmpty(difLastBuyEarnStr)) {
            Log.e("difBuyStr", "difLastBuyEarnStr: " + difLastBuyEarnStr + "----term:" + allLists.get(term).getCTerm());
        }
        if (term < allLists.size()) {
            setDifLastMap(term);
        }
    }


    private String[] getNum(int i) {
        MyBean.ListBean listBean = allLists.get(i);
        return listBean.getCTermResult().split(",");
    }

    private void getNumBlankData(int term, int blank) {

        positionList.clear();
        positionList = initList(0);
        templepositionList.clear();
        templepositionList = initList(0);
        templepositionMoreList.clear();
        templepositionMoreList = initList(0);

        for (int i = term; i < allLists.size(); i++) {
            for (int j = 0; j < 10; j++) {
                String[] split = getNum(i);
                getPositionData(Integer.parseInt(split[j])-1, j);
            }
        }
        for (int i = blank + term; i < allLists.size(); i++) {

            for (int j = 0; j < 10; j++) {
                String[] split = getNum(i);
                getTemplePositionData(Integer.parseInt(split[j])-1, j);
            }
        }

        for (int i = blank + term + 1; i < allLists.size(); i++) {
            for (int j = 0; j < 10; j++) {
                String[] split = getNum(i);
                getTempleMorePositionData(Integer.parseInt(split[j])-1, j);
            }
        }


        for (int i = 0; i < positionList.size(); i++) {

            for (int j = 0; j < 10; j++) {

                if ((positionList.get(i)[j] == templepositionList.get(i)[j]) && (templepositionMoreList.get(i)[j] != templepositionList.get(i)[j])) {

//                    Log.e("********size~~~" + term, ",位置：" + (i + 1) + ",数字：" + (j + 1) + "---" + positionList.get(i)[j] + ",blank:" + blank);

//                    if (blank <= (MAX_2 + 1)) {
////                        if (blank < MAX_2 && trueMap.get(i * 10 + j) == -1) {
////                            difbuyCount++;
////                        }
//                    }
                    trueMap.put(i * 10 + j, blank);
//                    else {
//
//                        if (largerMap.get(i * 10 + j) == -1) {
//                            difLargerCount++;
//                        }
//                        largerMap.put(i * 10 + j, blank);
//                    }

                }
            }

        }
    }



    private void getTempleMorePositionData(Integer integer, int i) {
        templepositionMoreList.get(i)[integer]++;
    }


    private void getTemplePositionData(int integer, int i) {
        templepositionList.get(i)[integer]++;
    }

    private void getNumData(Integer integer, int i) {
        numList.get(integer)[i]++;
    }

    private void getPositionData(Integer integer, int i) {
        positionList.get(i)[integer]++;
    }

    private void setDifLastMap(int term) {


        Iterator<Map.Entry<Integer, Integer>> iterator = trueMap.entrySet().iterator();
        difBuyStr = "";
        while (iterator.hasNext()) {
            Map.Entry<Integer, Integer> next = iterator.next();
//            if (next.getValue() <= MAX_2) {
//            }
            lastPositionMap.put(next.getKey(), next.getValue());
            if (next.getValue() != -1) {
                difBuyStr = difBuyStr + "\n" + "位置:" + next.getKey() + ",blank:" + next.getValue();
                buyPositionArray[next.getValue()]++;
                if (next.getValue() <= MAX_2) {
                    BUY_AMOUNT = BUY_AMOUNT - 10;
                    difbuyCount++;
                }
                if (next.getValue() >= BiggerInt) {
                    biggercount++;
                }
            }
//            if (next.getValue() > 0) {
//                Log.e("!!!!!!!!!!!!", "setLastMap: ");
//            }
        }
        Log.e("BUY_AMOUNT", "BUY_AMOUNT: " + BUY_AMOUNT + "-trem:" + allLists.get(term).getCTerm() + "-difbuyCount:" + difbuyCount + "-biggercount:" + biggercount);

        if (!TextUtils.isEmpty(difBuyStr)) {
            Log.e("difBuyStr", "difBuyStr: " + difBuyStr + "----term:" + allLists.get(term).getCTerm());
        }
    }



    private void getProgress(final int j) {

        this. runOnUiThread(new Runnable() {
            @Override
            public void run() {
                tvResult.setText(j + "");
            }
        });
    }



    public static Set<Integer> generateRandomArray(int size){

        Set<Integer> set = new LinkedHashSet<Integer>(); //集合是没有重复的值,LinkedHashSet是有顺序不重复集合,HashSet则为无顺序不重复集合
        Integer num = size;
        Integer range = size;
        Random ran = new Random();
        while(set.size() < num){
            Integer tmp = ran.nextInt(range); //0-51之间随机选一个数
            set.add(tmp);//直接加入，当有重复值时，不会往里加入，直到set的长度为52才结束
        }
        return set;
    }



}
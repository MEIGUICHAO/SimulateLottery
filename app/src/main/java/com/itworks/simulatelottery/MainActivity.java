package com.itworks.simulatelottery;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.google.gson.Gson;
import com.itworks.simulatelottery.volley.CacheUtils;
import com.itworks.simulatelottery.volley.VolleyManager;

import java.sql.Date;
import java.text.SimpleDateFormat;
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
    private int BEGIN_INT = 15;
    private EditText et_blank;
    private int BLANK_COUNT = 0;
    private ArrayList<int[]> allcountList;
    private ArrayList<int[]> lastSizeList;
    private ArrayList<int[]> blankCountList;
    private ArrayList<int[]> buyPositonList;
    private int CURRENT_BLANK;
    private int END_BLANK = 200;
    private int BUY_AMOUNT = 15;
    private int AMOUNT_CURRENT = 0;
    private int RECORD_AMOUNT = 0;
    private EditText et_endBlank;
    private EditText et_length;
    private int LENGTH = 2000;
    private int SIZE = 1;

    private int LESS_AMOUNT = 0;
    private int ALI_LESS_AMOUNT = 0;
    private int BIGGEST_AMOUNT = 0;
    private int ALI_MORE_AMOUNT = 0;
    private int ALL_AMOUNT = 0;
    private int TODAY_AMOUNT = 0;
    private int END_BUY = 0;
    private EditText et_size;
    private HashMap<Integer, Integer> buyPositionMap;
    private HashMap<Integer, Integer> buyNumMap;
    private HashMap<Integer, Integer> trueMap;
    private HashMap<Integer, Integer> lastPositionMap;
    private HashMap<Integer, Integer> recordMap;
    private HashMap<Integer, Integer> record2Map;
    private HashMap<Integer, Integer> lastNumMap;
    private int LAST_TREM = -1;

    //end
    private int MAX_2 = 65;
    private int BLANK_2 = 15;

    private int count = 0;
    private EditText et_endBuy;
    private Button btn_two;
    private EditText et_max2Int;
    private EditText et_less_blank;
    private int difbuyCount;
    private int lastdifCount;

    private double difNUm = 0;
    private String difBuyStr;
    private String difLastBuyEarnStr;

    private String myurlxyft = "http://api.kaijiangtong.com/lottery/?name=xyft&format=json2&uid=533810&token=8ecc79c616cc9475d246369db1165d9466df61e7&date=";
    private String myurlpk10 = "http://api.kaijiangtong.com/lottery/?name=bjpks&format=json2&uid=533810&token=8ecc79c616cc9475d246369db1165d9466df61e7&date=";
    private String Url;
    private ArrayList<String> urlsList;

    private int year = 2017;
    private int month = 8;
    private int day = 5;
    private String refreshUrl;
    private int index = 0;
    int urlNum = 2;
    private EditText et_date;
    private EditText et_urlnum;
    private Button btn_change;
    private EditText et_bigbegin;
    private int Bint = 45;

    private int BiggerInt = 3;
    private int DANGER = 15;

    private String type = "SC";
    private boolean IS_SC = true;
    //    private int[] earnPositionArray;
//    private int[] buyPositionArray;
    private boolean CAN_BUY = true;
    private boolean LAST_CAN_BUY;
    private EditText et_danger;
    private int bigge2030rcount;
    private int bigge3040rcount;
    private int bigge4050rcount;
    private int bigge50rcount;
    private int bigge1020rcount;
    private int bigge110rcount;

    private int[] count0;
    private int[] count110;
    private int[] count1020;
    private int[] count2030;
    private int[] count3040;
    private int[] count4050;
    private int[] count50;

    private int[] count0less;
    private int[] count110less;
    private int[] count1020less;
    private int[] count2030less;
    private int[] count3040less;
    private int[] count4050less;
    private int[] count50less;
    private String sameStr;
    private int positionCount;
    private int numCount;
    private String positionStr;
    private String numStr;
    private String str0;
    private String str0less;
    private int sameCount;
    private String strSame0;
    private String strSame0less;
    private String numBlankStr;
    private String positionBlankStr;
    private boolean positionContinue;
    private boolean numContinue;
    private int[] fiboArr;
    private int fibIndex = 0;
    private String biggerStr;
    private int fibLength = 33;
    private int dangerIndex;
    private int urlIndex = -1;
    private boolean CANT_BUY;
    private TextView tv_earn;
    private TextView tv_buy;
    private TextView tv_end;
    private String earnDispalyStr;
    private boolean DIF35BEGIN;
    private boolean DIF5060 = false;
    private int LOST_MOST_TODAY;
    private String BIGGEST_TERM;
    private boolean NEED_ADD;
    private String lastBuyStr;
    private HashMap<Integer, String> blankMap;
    private HashMap<Integer, Integer> beginCountMap;
    private String beginCountStr;
    private String beginStr;
    private HashMap<Integer, Integer> beginMap;
    private HashMap<Integer, Integer> beginCountRecordMap;
    private int BEGIN_COUNT = 5;
    //    private int record4050;


    /*
    *
    * 15-20
    *
    * */


    private void initBaseData() {

        if (null == allLists) {
            allLists = new ArrayList<MyBean.ListBean>();

            lastSizeList = initList(-1);
//            allcountList = initList(0);
            blankCountList = initList(0);
            buyPositonList = initList(-1);
        }
//        earnPositionArray = new int[200];
//        buyPositionArray = new int[200];

        initCountIntArray();

//        for (int i = 0; i < 110; i++) {
//            earnPositionArray[i] = 0;
//            buyPositionArray[i] = 0;
//        }

        if (null == buyPositionMap) {
            buyPositionMap = new HashMap<Integer, Integer>();
            recordMap = new HashMap<Integer, Integer>();
            record2Map = new HashMap<Integer, Integer>();
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

    private void initCountIntArray() {

        count0 = new int[100];
        count110 = new int[100];
//        count1020 = new int[100];
//        count2030 = new int[100];
//        count3040 = new int[100];
//        count4050 = new int[100];
//        count50 = new int[100];

        count0less = new int[100];
        count110less = new int[100];
//        count1020less = new int[100];
//        count2030less = new int[100];
//        count3040less = new int[100];
//        count4050less = new int[100];
//        count50less = new int[100];

    }

    private void resetBuyMap() {

        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                buyPositionMap.put(i * 10 + j, -1);
                buyNumMap.put(i * 10 + j, -1);
            }

        }
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                trueMap.put(i * 10 + j, -1);
                record2Map.put(i * 10 + j, -1);
            }

        }
        resetBlankMap();
    }

    private void resetBlankMap() {
        if (null == blankMap) {
            blankMap = new HashMap<Integer, String>();
        }
        for (int i = BEGIN_INT; i <= MAX_2; i++) {
            blankMap.put(i, "");

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
        et_endBlank.setVisibility(View.GONE);
        et_length = (EditText) findViewById(R.id.et_length);
        et_size = (EditText) findViewById(R.id.et_size);
        et_endBuy = (EditText) findViewById(R.id.et_endBuy);
        et_max2Int = (EditText) findViewById(R.id.et_max2Int);
        et_less_blank = (EditText) findViewById(R.id.et_less_blank);
        et_bigbegin = (EditText) findViewById(R.id.et_bigbegin);
        et_danger = (EditText) findViewById(R.id.et_danger);

        et_date = (EditText) findViewById(R.id.et_date);
        et_urlnum = (EditText) findViewById(R.id.et_urlnum);
        btn_two = (Button) findViewById(R.id.btn_two);
        btn_change = (Button) findViewById(R.id.btn_change);

        tv_earn = (TextView) findViewById(R.id.tv_earn);
        tv_buy = (TextView) findViewById(R.id.tv_buy);
        tv_end = (TextView) findViewById(R.id.tv_end);

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String strTime = sdf.format(new java.util.Date(System.currentTimeMillis()));
        et_date.setText(strTime);
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


        initFibArr();

    }

    private void initFibArr() {
        fiboArr = new int[fibLength];
//            fiboArr[0] = fiboArr[1] = fiboArr[2] = fiboArr[3] = fiboArr[4] = fiboArr[5]= fiboArr[6] = fiboArr[7]= fiboArr[8] = fiboArr[9] = 1;
//            fiboArr[10] = fiboArr[11]= fiboArr[12] = fiboArr[13]= fiboArr[14] = fiboArr[0] + fiboArr[9];
//            fiboArr[15] = fiboArr[16]= fiboArr[17] = fiboArr[18]= fiboArr[19] = fiboArr[9] + fiboArr[10];
//            fiboArr[20] = fiboArr[21]= fiboArr[22] = fiboArr[23]= fiboArr[24] = fiboArr[10] + fiboArr[15];
//            fiboArr[25] = fiboArr[26]= fiboArr[27] = fiboArr[28]= fiboArr[29] = fiboArr[15] + fiboArr[20];
//            fiboArr[30] = fiboArr[31]= fiboArr[32] = fiboArr[33]= fiboArr[34] = fiboArr[20] + fiboArr[25];


//        for (int i = 0; i < fibLength; i++) {
//
//            if (i >= 0 && i < 6) {
//                fiboArr[i] = 1;
//            }
//            if (i >= 6 && i < 9) {
//                fiboArr[i] = 2;
//            }
//            if (i >= 9 && i < 12) {
//                fiboArr[i] = 3;
//            }
//            if (i >= 12 && i < 15) {
//                fiboArr[i] = 5;
//            }
//            if (i >= 15 && i < 18) {
//                fiboArr[i] = 8;
//            }
//            if (i >= 18 && i < 21) {
//                fiboArr[i] = 13;
//            }
//            if (i >= 21 && i < 24) {
//                fiboArr[i] = 21;
//            }
//            if (i >= 24 && i < 27) {
//                fiboArr[i] = 34;
//            }
//            if (i >= 27 && i < 30) {
//                fiboArr[i] = 55;
//            }
//            if (i >= 30 && i < 33) {
//                fiboArr[i] = 89;
//            }
//        }

//            fiboArr[0] = fiboArr[1] = fiboArr[2] = fiboArr[3] = fiboArr[4] = fiboArr[5] = 1;
//            fiboArr[6] = fiboArr[7]= fiboArr[8] = fiboArr[4] + fiboArr[5];
//            fiboArr[9] = fiboArr[10] = fiboArr[11] = fiboArr[5] + fiboArr[6];
//            fiboArr[12] = fiboArr[13] = fiboArr[14] = fiboArr[6] + fiboArr[9];
//            fiboArr[15] = fiboArr[16] = fiboArr[17] = fiboArr[9] + fiboArr[12];
//            fiboArr[18] =fiboArr[19] = fiboArr[20] = fiboArr[12] + fiboArr[15];
//            fiboArr[21] = fiboArr[22] = fiboArr[23] = fiboArr[15] + fiboArr[18];


//        fiboArr[0] = fiboArr[1] = 1;
//        for (int i = 2; i < 7; i++) {
////            fiboArr[i] = 1;
//            fiboArr[i] = fiboArr[i - 1] + fiboArr[i - 2];
//        }
//        fiboArr[7] = fiboArr[8] = 1;
//        for (int i = 9; i < 14; i++) {
//
//            fiboArr[i] = fiboArr[i - 1] + fiboArr[i - 2];
//        }
//        fiboArr[14] = fiboArr[15] = 1;
//        for (int i = 16; i < 21; i++) {
//            fiboArr[i] = fiboArr[i - 1] + fiboArr[i - 2];
//        }
//        if (fiboArr == null) {
//        }
        for (int i = 0; i < fibLength; i++) {

            if (i >= 0 && i < 2) {
                fiboArr[i] = 1;
            }
            if (i >= 2 && i < 5) {
                fiboArr[i] = 2;
            }
            if (i >= 5 && i < 8) {
                fiboArr[i] = 3;
            }
            if (i >= 8 && i < 10) {
                fiboArr[i] = 5;
            }
            if (i >= 10 && i < 12) {
                fiboArr[i] = 8;
            }
            if (i >= 12 && i < 21) {
                fiboArr[i] = 13;
            }
            if (i >= 21 && i < 24) {
                fiboArr[i] = 21;
            }
            if (i >= 24 && i < 27) {
                fiboArr[i] = 34;
            }
            if (i >= 27 && i < 30) {
                fiboArr[i] = 55;
            }
            if (i >= 30 && i < 33) {
                fiboArr[i] = 89;
            }
        }
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
        urlIndex = -1;
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
        String mDanger = et_danger.getText().toString();
        if (!TextUtils.isEmpty(date)) {
            String[] split = date.split("-");
            year = Integer.parseInt(split[0]);
            month = Integer.parseInt(split[1]);
            day = Integer.parseInt(split[2]);
        }
        if (!TextUtils.isEmpty(mDanger)) {
            DANGER = Integer.parseInt(mDanger);
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
            BEGIN_INT = Integer.parseInt(blank);
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

        Log.e("BEGIN_INT", "BEGIN_INT: " + BEGIN_INT);
        Log.e("BEGIN_INT", "END_BLANK: " + END_BLANK);
        Log.e("BEGIN_INT", "LENGTH: " + LENGTH);
        Log.e("BEGIN_INT", "BUY_AMOUNT: " + BUY_AMOUNT);
        Log.e("BEGIN_INT", "SIZE: " + SIZE);

        initBaseData();

        for (int m = 0; m < SIZE; m++) {

            ALI_MORE_AMOUNT = 0;
            ALI_LESS_AMOUNT = 0;
            BIGGEST_AMOUNT = 0;
            ALL_AMOUNT = 0;
            BUY_AMOUNT = 0;
            TODAY_AMOUNT = 0;
            AMOUNT_CURRENT = 0;
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

        if (-1 == urlIndex) {
            this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    tv_end.setText(" ");
                }
            });


            urlIndex = urlsList.size() - 1;
        } else if (-2 != urlIndex && -1 != urlIndex && urlIndex > 0) {
            urlIndex--;
        } else {
            urlIndex = -2;
        }
        allLists.clear();
        fibIndex = 0;
        ALI_MORE_AMOUNT = 0;
        ALI_LESS_AMOUNT = 0;
        LOST_MOST_TODAY = 0;
        BIGGEST_AMOUNT = 0;
        BUY_AMOUNT = 0;
        TODAY_AMOUNT = 0;
        CANT_BUY = false;
        DIF35BEGIN = false;
        if (urlIndex - 2 >= 0) {
            for (int i = urlIndex - 2; i < urlIndex; i++) {
                gsonParse(CacheUtils.getCache(this, type + urlsList.get(i)));
                Log.e("BUY_AMOUNT", "url: " + urlsList.get(i));
            }
        }

        for (int i = allLists.size() / 2; i >= 0; i--) {

            record2Map.clear();
            if (i <= (allLists.size() - BEGIN_INT)) {
                resetBuyMap();
                CAN_BUY = true;
                for (int j = 1; j < END_BLANK; j++) {
                    getNumBlankData(i, j);
                }
//                    get2PostionBuyMap(i);
                LAST_TREM = i;
//                    setLastMap(i);
            }
            difLastBuyEarnStr = "";
            try {
                getDifPositionBuyMap(i);
            } catch (Exception e) {

            }
            lastdifCount = difbuyCount;
            getProgress(i);
        }

//        if (ALI_LESS_AMOUNT > LESS_AMOUNT) {
//            ALI_LESS_AMOUNT = LESS_AMOUNT;
//        }

        if (urlIndex > 1) {
            final String date = urlsList.get(urlIndex - 2).split("&date=")[1];
            if (TODAY_AMOUNT > 0) {
                Log.e("end", "end: " + "earn+++urlIndex:" + urlIndex + "-TODAY_AMOUNT:" + TODAY_AMOUNT + "-ALI_LESS_AMOUNT:" + ALI_LESS_AMOUNT + "-LOST_MOST_TODAY:" + LOST_MOST_TODAY + "-AMOUNT_CURRENT:" + AMOUNT_CURRENT + "-BIGGEST_AMOUNT:" + BIGGEST_AMOUNT + "-" + date + "-BIGGEST_TERM:" + BIGGEST_TERM);
            } else {
                Log.e("end", "end: " + "lost---urlIndex:" + urlIndex + "-TODAY_AMOUNT:" + TODAY_AMOUNT + "-ALI_LESS_AMOUNT:" + ALI_LESS_AMOUNT + "-LOST_MOST_TODAY:" + LOST_MOST_TODAY + "-AMOUNT_CURRENT:" + AMOUNT_CURRENT + "-BIGGEST_AMOUNT:" + BIGGEST_AMOUNT + "-" + date + "-BIGGEST_TERM:" + BIGGEST_TERM);
            }
            final String endDispalyStr = tv_end.getText().toString() + "\n" + "end: " + "-urlIndex:" + urlIndex + "-TODAY_AMOUNT:" + TODAY_AMOUNT + "-ALI_LESS_AMOUNT:" + ALI_LESS_AMOUNT + "-LOST_MOST_TODAY:" + LOST_MOST_TODAY + "-BIGGEST_AMOUNT:" + BIGGEST_AMOUNT + "-AMOUNT_CURRENT:" + AMOUNT_CURRENT + "-date:" + date;

            this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    tv_end.setText(endDispalyStr);
                }
            });
            ALI_MORE_AMOUNT = 0;
            ALI_LESS_AMOUNT = 0;
            BIGGEST_AMOUNT = 0;
            afterNet();
        }

    }

    private void getDataFromNet() {

        if (IS_SC) {
            Url = myurlpk10;
        } else {
            Url = myurlxyft;
        }
        String cache = CacheUtils.getCache(this, type + urlsList.get(index));
        if (!TextUtils.isEmpty(cache)) {
            try {
                gsonParse(cache);
            } catch (Exception e) {
                CacheUtils.putCache(this, type + urlsList.get(index), "");
            }
            index++;
            if (index < urlNum) {
                getDataFromNet();
            } else {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        afterNet();
                    }
                }).start();
            }
        } else {

            VolleyManager.newInstance().StrRequest("TAG", Request.Method.GET, urlsList.get(index), new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    CacheUtils.putCache(MainActivity.this, type + urlsList.get(index), response);


                    try {
                        gsonParse(response);
                    } catch (Exception e) {
                        CacheUtils.putCache(MainActivity.this, type + urlsList.get(index), "");
                    }
                    index++;
                    Toast.makeText(MainActivity.this, "成功：" + index, Toast.LENGTH_SHORT).show();

                    try {
                        Thread.sleep(1000);
                        if (index < urlNum) {
                            getDataFromNet();
                        } else {
                            new Thread(new Runnable() {
                                @Override
                                public void run() {
                                    afterNet();
                                }
                            }).start();

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

    private void gsonParse(String result) {

        try {
            Gson gson = new Gson();
            MyBean pcOriginBean = gson.fromJson(result, MyBean.class);
            allLists.addAll(pcOriginBean.getList());
        } catch (Exception e) {

        }
    }


    private void getDifPositionBuyMap(int term) {
        if (lastdifCount > 0) {
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {

                    if (null != lastPositionMap.get(i * 10 + j)) {

                        if (!CANT_BUY && lastPositionMap.size() > 0 && -1 != lastPositionMap.get(i * 10 + j)
                                && lastPositionMap.get(i * 10 + j) > record2Map.get(i * 10 + j) && (difBuyStr).contains("位置:" + (i * 10 + j) + ",blank:" + lastPositionMap.get(i * 10 + j))
//
                                && -1 == record2Map.get(i * 10 + j) && lastPositionMap.get(i * 10 + j) <= MAX_2 && LAST_CAN_BUY) {

//                            int buyAmount = fiboArr[beginCountMap.get(i * 10 + j) - BEGIN_COUNT];
                            int buyAmount = fiboArr[lastPositionMap.get(i * 10 + j) - (BEGIN_INT + 10)];
                            BUY_AMOUNT = BUY_AMOUNT + 99 * buyAmount;
                            TODAY_AMOUNT = TODAY_AMOUNT + 99 * buyAmount;
                            AMOUNT_CURRENT = AMOUNT_CURRENT + 99 * buyAmount;
//                            BUY_AMOUNT = BUY_AMOUNT + 99 * fiboArr[lastPositionMap.get(i * 10 + j) - (BEGIN_INT + 10)];
//                            TODAY_AMOUNT = TODAY_AMOUNT + 99 * fiboArr[lastPositionMap.get(i * 10 + j) - (BEGIN_INT + 10)];
//                            AMOUNT_CURRENT = AMOUNT_CURRENT + 99 * fiboArr[lastPositionMap.get(i * 10 + j) - (BEGIN_INT + 10)];
                            difLastBuyEarnStr = difLastBuyEarnStr + "\n" + "位置:" + (i * 10 + j) + ",blank:" + lastPositionMap.get(i * 10 + j);
                            Log.e("difBuyStr", "RealBuyEarnStr: " + (i * 10 + j) + ",blank:" + lastPositionMap.get(i * 10 + j) + "buyAmount:" + buyAmount
                                    + "earnAmount:" + 99 * buyAmount);
                            earnDispalyStr = "BUY_AMOUNT_EARN~~~~: " + BUY_AMOUNT + "-trem:" + allLists.get(term).getCTermDT() + "-lastdifCount:" + lastdifCount + "-blank:" + lastPositionMap.get(i * 10 + j) + "-ALL_AMOUNT:"
                                    + ALL_AMOUNT + "-ALI_MORE_AMOUNT:" + ALI_MORE_AMOUNT + "-TODAY_AMOUNT:" + TODAY_AMOUNT + "-BIGGEST_AMOUNT:" + BIGGEST_AMOUNT + "-AMOUNT_CURRENT:" + AMOUNT_CURRENT;
                            Log.e("BUY_AMOUNT", earnDispalyStr);
                            this.runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    tv_earn.setText(earnDispalyStr);

                                }
                            });
//                            if (null != beginCountMap.get(i * 10 + j)) {
//                                Log.e("BUY_AMOUNT", beginCountMap.get(i * 10 + j) + "");
//                                beginCountMap.remove(i * 10 + j);
//                            }

                        }
                    }

//                    if (null != beginMap.get(i * 10 + j)) {
//                        if (beginMap.get(i * 10 + j) > record2Map.get(i * 10 + j)) {
//
//                            if (null != beginCountMap.get(i * 10 + j)) {
//                                Log.e("BUY_AMOUNT", beginCountMap.get(i * 10 + j) + "");
//                                beginCountMap.remove(i * 10 + j);
//                            }
//                        }
//                    }

                }

            }
        }


        if (ALI_MORE_AMOUNT <= BUY_AMOUNT && BUY_AMOUNT > 0) {
            DIF35BEGIN = false;
            fibIndex = 0;
        }

        if (ALI_MORE_AMOUNT >= 300) {
            BUY_AMOUNT = 0;
            ALI_MORE_AMOUNT = 0;
        }

        if (BIGGEST_AMOUNT < TODAY_AMOUNT) {
            BIGGEST_AMOUNT = TODAY_AMOUNT;
            BIGGEST_TERM = allLists.get(term).getCTermDT();
        }
//        if (BUY_AMOUNT <= -1000 && fibIndex > 20) {
//            fibIndex = 0;
////            BUY_AMOUNT = 0;
////            ALI_MORE_AMOUNT = 0;
//        }

//        if (ALI_MORE_AMOUNT < 300 + BUY_AMOUNT && fibIndex > fibLength / 2) {
//            fibIndex = 0;
//        }
        if (ALI_MORE_AMOUNT > ALL_AMOUNT) {
            ALL_AMOUNT = ALI_MORE_AMOUNT;
        }

        if (ALI_MORE_AMOUNT <= BUY_AMOUNT) {
            ALI_MORE_AMOUNT = BUY_AMOUNT;
            fibIndex = 0;
        } else {
            if (fibIndex < (fibLength - 1)) {
//                if ((BUY_AMOUNT - RECORD_AMOUNT) >= 1000 && fibIndex >= 10) {
//
////                    fibIndex = 0;
//                } else
                if (lastdifCount >= (DANGER - 2) && !TextUtils.isEmpty(biggerStr) && DIF35BEGIN && !DIF5060
//                        && ((ALI_MORE_AMOUNT - BUY_AMOUNT) > 200)
                        ) {

//                    dangerIndex = 0;
                } else {
                    if (BUY_AMOUNT == RECORD_AMOUNT) {
//                    dangerIndex++;
//                    if (dangerIndex >= 10) {
//                        fibIndex = 0;
//                    }
                    }
                }
            } else {
                fibIndex = 0;
            }
        }
        if (BUY_AMOUNT > RECORD_AMOUNT) {
            NEED_ADD = false;
        } else if (BUY_AMOUNT < RECORD_AMOUNT) {
            NEED_ADD = true;
        }
        difbuyCount = 0;
        sameStr = "";
        sameCount = 0;
//        record4050 = 0;

        biggerStr = "-";
        DIF5060 = false;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {

                if (TextUtils.isEmpty(blankMap.get(record2Map.get(i * 10 + j)))) {
                    blankMap.put(record2Map.get(i * 10 + j), (i * 10 + j) + "");
                } else {
                    String blankStr = blankMap.get(record2Map.get(i * 10 + j));
                    blankMap.put(record2Map.get(i * 10 + j), blankStr + "---" + (i * 10 + j));
                }
            }

        }

        if (null == beginCountMap) {
            beginCountMap = new HashMap<Integer, Integer>();
        }
        beginMap = new HashMap<Integer, Integer>();
        recordMap.clear();
        for (int i = BEGIN_INT; i <= MAX_2 + 1; i++) {
            if (BiggerInt == 1) {
                if (!TextUtils.isEmpty(blankMap.get(i))) {
                    if (!blankMap.get(i).contains("---") ) {
                        beginMap.put(Integer.parseInt(blankMap.get(i)), i);
                        if (i <= (MAX_2)) {
                            int index = Integer.parseInt(blankMap.get(i));

                            if (!TextUtils.isEmpty(beginStr) && beginStr.contains(index + "--")) {
                                if (null == beginCountMap.get(index)) {
                                    beginCountMap.put(index, 0);
                                } else {
                                    Integer count = beginCountMap.get(index);
                                    Integer integer = count + 1;
                                    beginCountMap.put(index, integer);
                                }
                            } else {
                                beginCountMap.put(index, 0);
                            }
                            if (i >= ((BEGIN_INT + 10)) && beginCountMap.get(Integer.parseInt(blankMap.get(i))) > BEGIN_COUNT) {
                                trueMap.put(index, i);
                                recordMap.put(index, i);
                            }
                        }
//                        else {
//                            if (null != beginCountMap.get(Integer.parseInt(blankMap.get(i)))) {
//                                beginCountMap.remove(Integer.parseInt(blankMap.get(i)));
//                            }
//                        }
                    }
                }
            } else {
                final String[] split = blankMap.get(i).split("---");
                if (split.length == BiggerInt) {
                    for (String str : split) {
                        trueMap.put(Integer.parseInt(str), i);
                        recordMap.put(Integer.parseInt(str), i);
                    }
                }
            }
        }
        if (null == beginCountRecordMap) {
            beginCountRecordMap = new HashMap<Integer, Integer>();
            resetBeginCountMap();
        } else {

            Iterator<Map.Entry<Integer, Integer>> iterator = beginCountRecordMap.entrySet().iterator();
            while (iterator.hasNext()) {
                Map.Entry<Integer, Integer> next = iterator.next();
                if (next.getValue() == beginCountMap.get(next.getKey())) {
                    beginCountMap.remove(next.getKey());
                }
            }
            beginCountRecordMap.clear();
            resetBeginCountMap();
        }


        if (!TextUtils.isEmpty(difLastBuyEarnStr)) {
            Log.e("difBuyStr", "difLastBuyEarnStr: " + difLastBuyEarnStr + "----term:" + allLists.get(term).getCTerm() + "--:" + BUY_AMOUNT);
        }

        Log.e("BUY_AMOUNT", "biggerStr: " + biggerStr);


        if (term < allLists.size()) {
            setDifLastMap(term);
        }
    }

    private void resetBeginCountMap() {
        Iterator<Map.Entry<Integer, Integer>> iterator = beginCountMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, Integer> next = iterator.next();
            beginCountRecordMap.put(next.getKey(), next.getValue());
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
                getPositionData(Integer.parseInt(split[j]) - 1, j);
            }
        }
        for (int i = blank + term; i < allLists.size(); i++) {

            for (int j = 0; j < 10; j++) {
                String[] split = getNum(i);
                getTemplePositionData(Integer.parseInt(split[j]) - 1, j);
            }
        }

        for (int i = blank + term + 1; i < allLists.size(); i++) {
            for (int j = 0; j < 10; j++) {
                String[] split = getNum(i);
                getTempleMorePositionData(Integer.parseInt(split[j]) - 1, j);
            }
        }


        for (int i = 0; i < positionList.size(); i++) {

            for (int j = 0; j < 10; j++) {

                if ((positionList.get(i)[j] == templepositionList.get(i)[j]) && (templepositionMoreList.get(i)[j] != templepositionList.get(i)[j])) {

//                    if (blank >= 200) {
//                        recordMap.put(i * 10 + j, blank);
//                    }
//                    if (blank >= BEGIN_INT) {
//                        trueMap.put(i * 10 + j, blank);
//                    }
//                    if (blank <= MAX_2) {
//                    }
                    record2Map.put(i * 10 + j, blank);
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

    private void setDifLastMap(final int term) {


//        if (recordMap.size() >= DANGER) {
//
//            CAN_BUY = true;
//        } else {
//            CAN_BUY = false;
//        }

        if (recordMap.size() >= DANGER) {
        }
        DIF35BEGIN = true;
        CAN_BUY = DIF35BEGIN;
//        if (LOST_MOST_TODAY < -2000) {
//            CANT_BUY = true;
//        }
//        if (TODAY_AMOUNT > 2000) {
//            CANT_BUY = true;
//        }

        if (fibIndex == 32) {
            CANT_BUY = true;
        }

        if (recordMap.size() < DANGER) {
            CAN_BUY = true;
        } else {
            CAN_BUY = false;
        }

//        if ((CAN_BUY && NEED_ADD) || (fibIndex < 6 && CAN_BUY)) {
        if (CAN_BUY) {
            fibIndex++;
        }
//        if (BIGGEST_AMOUNT < 150) {
//            fibIndex = 0;
//        }
//        if (BIGGEST_AMOUNT < 500 && TODAY_AMOUNT < -500) {
//            CANT_BUY = true;
//        }
//        if (BIGGEST_AMOUNT < 50 && TODAY_AMOUNT < -300) {
//            CANT_BUY = true;
//        }


        LAST_CAN_BUY = CAN_BUY;

//        if (DIF35BEGIN && recordMap.size() > DANGER + 2) {
//            CAN_BUY = false;
////            if (fibIndex > 0) {
////                fibIndex--;
////            }
//        }

//        if (TODAY_AMOUNT < -500) {
//            CANT_BUY = true;
//        }
//        if ((TODAY_AMOUNT - recordMap.size() * 10 * fiboArr[fibIndex]) < -3000) {
//            CANT_BUY = true;
//        }
//        if (TODAY_AMOUNT < -2000 && BIGGEST_AMOUNT < 800) {
//            CANT_BUY = true;
//        }
//        if (TODAY_AMOUNT > 7000) {
//            CANT_BUY = true;
//        }
//        if (BIGGEST_AMOUNT > 3500 && BUY_AMOUNT < -2000) {
//            CANT_BUY = true;
//        }

        Iterator<Map.Entry<Integer, Integer>> iterator = trueMap.entrySet().iterator();
        difBuyStr = "";
        lastBuyStr = "";
        RECORD_AMOUNT = BUY_AMOUNT;
        int more50 = 0;
        int more40 = 0;
        int more30 = 0;
        //TODO buy
        while (iterator.hasNext()) {
            Map.Entry<Integer, Integer> next = iterator.next();
            if (next.getValue() != -1) {
                if (!CANT_BUY && CAN_BUY && next.getValue() <= MAX_2 && next.getValue() >= BEGIN_INT && !TextUtils.isEmpty(biggerStr) && DIF35BEGIN && !DIF5060) {
                    if (TextUtils.isEmpty(lastBuyStr)) {
                        lastBuyStr = next.getKey() + "##" + next.getValue();
                    } else {
                        lastBuyStr = lastBuyStr + "----" + next.getKey() + "##" + next.getValue();
                    }
                    int buyAmount =  10 * fiboArr[next.getValue() - (BEGIN_INT + 10)];
//                    int buyAmount = 10 * fiboArr[beginCountMap.get(next.getKey()) - BEGIN_COUNT];
                    lastPositionMap.put(next.getKey(), next.getValue());
                    BUY_AMOUNT = BUY_AMOUNT - buyAmount;
                    AMOUNT_CURRENT = AMOUNT_CURRENT - buyAmount;
                    TODAY_AMOUNT = TODAY_AMOUNT - buyAmount;
                    difBuyStr = difBuyStr + "\n" + "位置:" + next.getKey() + ",blank:" + next.getValue() + ",buyAmount:" + buyAmount;

//                    BUY_AMOUNT = BUY_AMOUNT - 10 * fiboArr[next.getValue() - (BEGIN_INT + 10)];
//                    AMOUNT_CURRENT = AMOUNT_CURRENT - 10 * fiboArr[next.getValue() - (BEGIN_INT + 10)];
//                    TODAY_AMOUNT = TODAY_AMOUNT - 10 * fiboArr[next.getValue() - (BEGIN_INT + 10)];
                    difbuyCount++;
                } else {
                    lastPositionMap.put(next.getKey(), -1);

                }
            } else {
                lastPositionMap.put(next.getKey(), -1);
            }
        }
        beginStr = "";
        beginCountStr = "";

        Iterator<Map.Entry<Integer, Integer>> beginIt = beginMap.entrySet().iterator();
        while (beginIt.hasNext()) {
            Map.Entry<Integer, Integer> next = beginIt.next();
            beginStr = beginStr + "\n" + next.getKey() + "--" + next.getValue();
            lastPositionMap.put(next.getKey(), next.getValue());
        }
        Iterator<Map.Entry<Integer, Integer>> beginCountIt = beginCountMap.entrySet().iterator();
        while (beginCountIt.hasNext()) {
            Map.Entry<Integer, Integer> next = beginCountIt.next();
            if (next.getValue() > 0) {
                beginCountStr = beginCountStr + "\n" + next.getKey() + "--" + next.getValue();
            }
        }
        final String buyDisplayStr = "BUY_AMOUNT: " + BUY_AMOUNT + "-trem:" + allLists.get(term).getCTermDT() + "-difbuyCount:" + difbuyCount
                + "-fibIndex:" + fibIndex + "-ALI_MORE_AMOUNT:" + ALI_MORE_AMOUNT + "-TODAY_AMOUNT:" + TODAY_AMOUNT + "-ALL_AMOUNT:" + ALL_AMOUNT + "-ALI_LESS_AMOUNT:" + ALI_LESS_AMOUNT;

        Log.e("BUY_AMOUNT", buyDisplayStr);

        if (ALI_LESS_AMOUNT > BUY_AMOUNT) {
            ALI_LESS_AMOUNT = BUY_AMOUNT;
        }

        if (LOST_MOST_TODAY > TODAY_AMOUNT) {
            LOST_MOST_TODAY = TODAY_AMOUNT;
        }


        this.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                tv_buy.setText(buyDisplayStr);
            }
        });


        if (!TextUtils.isEmpty(difBuyStr)) {
            Log.e("difBuyStr", "RealBuyStr: " + difBuyStr + "----term:" + allLists.get(term).getCTerm() + "--:" + BUY_AMOUNT);
        }
        if (!TextUtils.isEmpty(beginCountStr)) {
            Log.e("difBuyStr", "beginCountStr: " + beginCountStr + "----term:" + allLists.get(term).getCTerm() + "--:" + BUY_AMOUNT);
        }
        if (!TextUtils.isEmpty(beginStr)) {
            Log.e("difBuyStr", "beginStr: " + beginStr + "----term:" + allLists.get(term).getCTerm() + "--:" + BUY_AMOUNT);
        }
//        else {
//            Log.e("difBuyStr", "difBuyStr: " + "----term:" + allLists.get(term).getCTerm() + "--:" + BUY_AMOUNT);
//
//        }
    }


    private void getProgress(final int j) {

        this.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                tvResult.setText(j + "");
            }
        });
    }


    public static Set<Integer> generateRandomArray(int size) {

        Set<Integer> set = new LinkedHashSet<Integer>(); //集合是没有重复的值,LinkedHashSet是有顺序不重复集合,HashSet则为无顺序不重复集合
        Integer num = size;
        Integer range = size;
        Random ran = new Random();
        while (set.size() < num) {
            Integer tmp = ran.nextInt(range); //0-51之间随机选一个数
            set.add(tmp);//直接加入，当有重复值时，不会往里加入，直到set的长度为52才结束
        }
        return set;
    }


}
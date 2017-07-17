package com.itworks.simulatelottery;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    private Button tvResult;
    private int allcount;
    private ArrayList<int[]> positionList;
    private ArrayList<int[]> numList;
    private ArrayList<int[]> templepositionList;
    private ArrayList<int[]> templepositionMoreList;
    private ArrayList<int[]> templenumList;
    private ArrayList<ArrayList<Integer>> allLists;
    private int BLANK_INT = 16;
    private EditText et_blank;
    private int BLANK_COUNT = 0;
    private ArrayList<int[]> allcountList;
    private ArrayList<int[]> lastSizeList;
    private ArrayList<int[]> blankCountList;
    private ArrayList<int[]> bugPositonList;
    private int CURRENT_BLANK;
    private int END_BLANK = 17;
    private int BUY_AMOUNT = 15;
    private EditText et_endBlank;
    private EditText et_length;
    private int LENGTH = 200;
    private int SIZE = 20;

    private int LESS_AMOUNT = 0;
    private int ALI_LESS_AMOUNT = 0;
    private int ALI_MORE_AMOUNT = 0;
    private int ALL_AMOUNT = 0;
    private EditText et_size;
    private HashMap<Integer, Integer> buyMap;
    private HashMap<Integer, Integer> LastMap;
    private int LAST_TREM = -1;


    private void initBaseData() {

        if (null == allLists) {
            allLists = new ArrayList<>();
            lastSizeList = initList(-1);
//            allcountList = initList(0);
            blankCountList = initList(0);
            bugPositonList = initList(-1);
        }


        if (null == buyMap) {
            buyMap = new HashMap<>();
            for (int i = 0; i <10; i++) {
                for (int j = 0; j < 10; j++) {
                    buyMap.put(i * 10 + j, -1);
                }

            }
        }

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

    private ArrayList<int[]> initList(int val) {
        ArrayList<int[]> list = new ArrayList<>();
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
        bugPositonList = initList(-1);
        String blank = et_blank.getText().toString();
        String endBlank = et_endBlank.getText().toString();
        String length = et_length.getText().toString();
        String size = et_size.getText().toString();
        if (!TextUtils.isEmpty(blank)) {
            BLANK_INT = Integer.parseInt(blank);
        }
        if (!TextUtils.isEmpty(endBlank)) {
            END_BLANK = Integer.parseInt(endBlank);
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
            allLists.clear();
            if (null == allcountList) {
                allcountList = initList(0);
            } else {
                allcountList.clear();
                allcountList = initList(0);
            }
            for (int j = 0; j < 200 + LENGTH; j++) {
                getProgress(j);
                ArrayList<Integer> integers = new ArrayList<>();
                Set<Integer> resultSet = generateRandomArray(10);
                Iterator<Integer> it = resultSet.iterator();

                //result
                while (it.hasNext()) {
                    integers.add(it.next());
                }
                allLists.add(0, integers);
            }


            for (int i = allLists.size() - 200; i > BLANK_INT; i--) {
                if (i <= (allLists.size() - BLANK_INT)) {
                    for (int j = BLANK_INT; j < END_BLANK; j++) {
                        getNumBlankData(i, j);
                    }
                    LAST_TREM = i;
                }
            }




//            for (int i = BLANK_INT + 1; i < allLists.size(); i++) {
//
//                initBaseData();
//                getResultData(BLANK_INT + 1, i);
//
//            }


            if (ALI_LESS_AMOUNT > LESS_AMOUNT) {
                ALI_LESS_AMOUNT = LESS_AMOUNT;
            }
            if (ALI_MORE_AMOUNT < BUY_AMOUNT) {
                ALI_MORE_AMOUNT = BUY_AMOUNT;
            }
            ALL_AMOUNT = ALL_AMOUNT + BUY_AMOUNT;
            Log.e("", "LESS_AMOUNT: " + LESS_AMOUNT + ",ALI_LESS_AMOUNT:" + ALI_LESS_AMOUNT + ",ALI_MORE_AMOUNT:" + ALI_MORE_AMOUNT + ",ALL_AMOUNT:" + ALL_AMOUNT);

        }




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
                getPositionData(allLists.get(i).get(j), j);
            }
        }
        for (int i = blank + term; i < allLists.size(); i++) {

            for (int j = 0; j < 10; j++) {
                getTemplePositionData(allLists.get(i).get(j), j);
            }
        }

        for (int i = blank + term + 1; i < allLists.size(); i++) {
            for (int j = 0; j < 10; j++) {
                getTempleMorePositionData(allLists.get(i).get(j), j);
            }
        }

        for (int i = 0; i < positionList.size(); i++) {

            for (int j = 0; j < 10; j++) {

                if ((positionList.get(i)[j] == templepositionList.get(i)[j]) && (templepositionMoreList.get(i)[j] != templepositionList.get(i)[j])) {

                    BUY_AMOUNT = BUY_AMOUNT - 10;
                    if (LESS_AMOUNT > BUY_AMOUNT) {
                        LESS_AMOUNT = BUY_AMOUNT;
                    }
                    Log.e("********size~~~" + term, ",位置：" + (i + 1) + ",数字：" + (j + 1) + "---" + positionList.get(i)[j] + ",blank:" + blank);

                    buyMap.put(i * 10 + j, blank);
                    if ()
//                    count++;
                } else {
                    if (buyMap.get(i * 10 + j) != -1 && (LAST_TREM - term == 1)&&null!=LastMap&&LastMap.get(i * 10 + j)!=LastMap.get(i * 10 + j)) {
                        BUY_AMOUNT = BUY_AMOUNT + 89;
                        Log.e("$$$$$$size：" + term + "!!!!", "EARN+位置：" + (i + 1) + ",数字：" + (j + 1) + ",BUY_AMOUNT-: " + BUY_AMOUNT);
                    }
                    buyMap.put(i * 10 + j, -1);
                }
            }

        }
        if (null == LastMap) {
            LastMap = new HashMap<>();
        }
        Iterator<Map.Entry<Integer, Integer>> iterator = buyMap.entrySet().iterator();
        while (iterator.hasNext()) {
            LastMap.put(iterator.next().getKey(), iterator.next().getValue());
        }
//        Log.e("!!!" + term, "sizeCount: " + count);


    }

    private void getResultData(int blank, int size) {

        for (int i = 0; i < size-1; i++) {
            for (int j = 0; j < 10; j++) {
                getPositionData(allLists.get(i).get(j), j);
            }
        }
        for (int i = 0; i < size-blank-1; i++) {
            for (int j = 0; j < 10; j++) {
                getTemplePositionData(allLists.get(i).get(j),j);
            }
        }

        for (int i = 0; i < size; i++) {
            for (int j = 0; j < 10; j++) {
                getTempleMorePositionData(allLists.get(i).get(j), j);
            }
        }


        for (int i = 0; i < positionList.size(); i++) {
            for (int j = 0; j < 10; j++) {
                if (positionList.get(i)[j] == templepositionList.get(i)[j] && templepositionList.get(i)[j] != templepositionMoreList.get(i)[j]) {
                    //profit
                    BUY_AMOUNT = BUY_AMOUNT + 89;
                    bugPositonList.get(i)[j] = -1;
//                    Log.e("BUY_AMOUNT", "BUY_AMOUNT+: " + BUY_AMOUNT);
                    Log.e("size：" + size + "!!!!", "EARN+位置：" + (i + 1) + ",数字：" + (j + 1) + ",BUY_AMOUNT-: " + BUY_AMOUNT);
                }
            }
        }

    }

    private void getTempleMorePositionData(Integer integer, int i) {
        templepositionMoreList.get(i)[integer]++;
    }

    private void getProgress(final int j) {

        this. runOnUiThread(new Runnable() {
            @Override
            public void run() {
                tvResult.setText(j + "");
            }
        });
    }


    private void getBlankDate(int blank, int size) {
        for (int i = size; i < allLists.size(); i++) {
            for (int j = 0; j < 10; j++) {
                getPositionData(allLists.get(i).get(j), j);
            }
        }
        for (int i = size + blank; i < allLists.size(); i++) {
            for (int j = 0; j < 10; j++) {
                getTemplePositionData(allLists.get(i).get(j), j);
            }
        }
        for (int i = size + blank + 1; i < allLists.size(); i++) {
            for (int j = 0; j < 10; j++) {
                getTempleMorePositionData(allLists.get(i).get(j), j);
            }
        }
        int count = 0;
        for (int i = 0; i < positionList.size(); i++) {
            for (int j = 0; j < 10; j++) {
                if ((positionList.get(i)[j] == templepositionList.get(i)[j])) {
                    count++;
                    Log.e("********size~~~" + size, ",位置：" + (i + 1) + ",数字：" + (j + 1) + "---" + positionList.get(i)[j] + ",blank:" + blank);
                    Log.e("!!!!!!!!!size~~~" + size, ",位置：" + (i + 1) + ",数字：" + (j + 1) + "---" + templepositionList.get(i)[j]);
                }
            }


        }
        Log.e("!!!" + size, "sizeCount: " + count);


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

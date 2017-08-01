package com.itworks.simulatelottery;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
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
    private ArrayList<Integer> numLists;
    private int BLANK_INT = 30;
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

    private int MAX_2 = 50;
    private int BLANK_2 = 15;

    private int count = 0;
    private EditText et_endBuy;
    private Button btn_two;
    private EditText et_max2Int;
    private EditText et_less_blank;
    private int buyCount;
    private int difbuyCount;
    private int lastCount;
    private int lastdifCount;

    private int position1 = 1;
    private int position2 = 2;
    private int sameSize = 3;
    private double difNUm = 5;
    private String difBuyStr;
    private String difLastBuyEarnStr;


    private void initBaseData() {

        if (null == allLists) {
            allLists = new ArrayList<>();

            lastSizeList = initList(-1);
//            allcountList = initList(0);
            blankCountList = initList(0);
            buyPositonList = initList(-1);
        }


        if (null == buyPositionMap) {
            buyPositionMap = new HashMap<>();
            buyNumMap = new HashMap<>();
            trueMap = new HashMap<>();
            lastPositionMap = new HashMap<>();
            lastNumMap = new HashMap<>();
            numLists = new ArrayList<>();
            resetBuyMap();
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
        et_endBuy = (EditText) findViewById(R.id.et_endBuy);
        et_max2Int = (EditText) findViewById(R.id.et_max2Int);
        et_less_blank = (EditText) findViewById(R.id.et_less_blank);
        btn_two = (Button) findViewById(R.id.btn_two);

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
        buyPositonList = initList(-1);
        String blank = et_blank.getText().toString();
        String endBlank = et_endBlank.getText().toString();
        String length = et_length.getText().toString();
        String size = et_size.getText().toString();
        String endbuy = et_endBuy.getText().toString();
        String max2int = et_max2Int.getText().toString();
        String lessBlank = et_less_blank.getText().toString();
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
            if (null == allcountList) {
                allcountList = initList(0);
            } else {
                allcountList.clear();
                allcountList = initList(0);
            }
            for (int j = 0; j < 200 + LENGTH; j++) {
                ArrayList<Integer> integers = new ArrayList<>();
                Set<Integer> resultSet = generateRandomArray(10);
                Iterator<Integer> it = resultSet.iterator();

                //result
                while (it.hasNext()) {
                    integers.add(it.next());
                }
                allLists.add(0, integers);
            }


            for (int i = allLists.size() - 200; i >= 0; i--) {
                difbuyCount = 0;
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

        }




    }

    private void getDifPositionBuyMap(int term) {
        difLastBuyEarnStr = "";
        if (lastdifCount > difNUm) {
            BUY_AMOUNT = BUY_AMOUNT - 10 * difbuyCount;
            Log.e("BUY_AMOUNT", "BUY_AMOUNT: " + BUY_AMOUNT + "-trem:" + term + "-difbuyCount:" + difbuyCount);
        }

        if (lastdifCount > difNUm) {
            for (int i = 0; i < 10; i++) {
                for (int j = 0; j < 10; j++) {

                    if (lastPositionMap.size() > 0 && -1 != lastPositionMap.get(i * 10 + j) && -1 == trueMap.get(i * 10 + j)) {
                        BUY_AMOUNT = BUY_AMOUNT + 99;
                        difLastBuyEarnStr = difLastBuyEarnStr + "\n" + "位置:" + (i * 10 + j) + "blank:" + lastPositionMap.get(i * 10 + j);
                        Log.e("BUY_AMOUNT", "BUY_AMOUNT_EARN~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~: " + BUY_AMOUNT + "-trem:" + term + "-buyCount:" + lastCount);
                    }

                }

            }
        }

        if (!TextUtils.isEmpty(difLastBuyEarnStr)) {
            Log.e("difBuyStr", "difLastBuyEarnStr: " + difLastBuyEarnStr + "----term:" + term);
        }
        if (difbuyCount > difNUm) {
            setDifLastMap(term);
        }
    }

    private void get2PostionBuyMap(int trem) {
        lastCount = buyCount;
        buyCount = 0;
        ArrayList<String> sortPositionList = new ArrayList<>();
        ArrayList<String> sortNumList = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            sortPositionList.clear();
            sortNumList.clear();
            for (int j = 0; j < 10; j++) {

                if (lastPositionMap.size() > 0 && -1 != lastPositionMap.get(i * 10 + j) && -1 == trueMap.get(i * 10 + j)) {
                    BUY_AMOUNT = BUY_AMOUNT + 99;
                    Log.e("BUY_AMOUNT", "BUY_AMOUNT_EARN~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~: " + BUY_AMOUNT + "-trem:" + trem + "-buyCount:" + lastCount);
                }

                if (lastNumMap.size() > 0 && -1 != lastNumMap.get(i + j * 10) && -1 == trueMap.get(i + j * 10)) {
                    BUY_AMOUNT = BUY_AMOUNT + 99;
                    Log.e("BUY_AMOUNT", "BUY_AMOUNT_EARN~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~: " + BUY_AMOUNT + "-trem:" + trem + "-buyCount:" + lastCount);
                }


                if (-1 != trueMap.get(i * 10 + j)) {
                    sortPositionList.add((i * 10 + j) + "-" + trueMap.get(i * 10 + j));
                }
                if (-1 != trueMap.get(i + j * 10)) {
                    sortNumList.add((i + j * 10) + "-" + trueMap.get(i + j * 10));
                }
            }
            if (sortPositionList.size() > sameSize) {

                sortList(sortPositionList, true, trem);
            }
            if (sortNumList.size() > sameSize) {

                sortList(sortNumList, false, trem);
            }

            if (i == 9) {
                setLastMap();
            }

        }

//        for (int i = 0; i < 10; i++) {
//            for (int j = 0; j < 10; j++) {
//
//                if (-1 != buyPositionMap.get(i * 10 + j) && -1 != buyNumMap.get(i * 10 + j)) {
//                    for (int k = 0; k < 10; k++) {
//                        buyPositionMap.put(i * 10 + k, -1);
//                        buyNumMap.put(k * 10 + j, -1);
//                    }
//                }
//            }
//        }
//        setLastMap();
//
//        for (int i = 0; i < 10; i++) {
//            for (int j = 0; j < 10; j++) {
//
//                if (-1 != buyPositionMap.get(i * 10 + j)) {
//                    BUY_AMOUNT = BUY_AMOUNT - 10;
//                }
//                if (-1 != buyNumMap.get(i * 10 + j)) {
//                    BUY_AMOUNT = BUY_AMOUNT - 10;
//                }
//            }
//
//        }
//        Log.e("BUY_AMOUNT", "BUY_AMOUNT-: " + BUY_AMOUNT + "-trem:" + trem);


    }

    private void setLastMap() {

        Iterator<Map.Entry<Integer, Integer>> iterator = buyPositionMap.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<Integer, Integer> next = iterator.next();
            lastPositionMap.put(next.getKey(), next.getValue());
//            if (next.getValue() > 0) {
//                Log.e("!!!!!!!!!!!!", "setLastMap: ");
//            }
        }

        Iterator<Map.Entry<Integer, Integer>> iterator2 = buyNumMap.entrySet().iterator();
        while (iterator2.hasNext()) {
            Map.Entry<Integer, Integer> next = iterator2.next();
            lastNumMap.put(next.getKey(), next.getValue());
//            if (next.getValue() > 0) {
//                Log.e("!!!!!!!!!!", "setLastMap: ");
//            }
        }

    }

    private void sortList(ArrayList<String> sortPositionList, boolean isPosition, int trem) {
        Collections.sort(sortPositionList, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                //降序序排列
                int int1 = Integer.parseInt(o1.split("-")[1]);
                int int2 = Integer.parseInt(o2.split("-")[1]);
                if (int1 < int2) {
                    return 1;
                }
                if (int1 == int2) {
                    return 0;
                }
                return -1;
            }
        });
        if (Integer.parseInt(sortPositionList.get(position1).split("-")[1]) > MAX_2
//                && ((Integer.parseInt(sortPositionList.get(0).split("-")[1]) - Integer.parseInt(sortPositionList.get(1).split("-")[1])) >= BLANK_2)
                ) {

            buyCount++;
//            Log.e("BUY_AMOUNT", "sortPositionList: " + sortPositionList.size() + "-trem:" + trem);
            if (isPosition) {
                buyPositionMap.put(Integer.parseInt(sortPositionList.get(position1).split("-")[0]), Integer.parseInt(sortPositionList.get(position1).split("-")[1]));
                buyPositionMap.put(Integer.parseInt(sortPositionList.get(position2).split("-")[0]), Integer.parseInt(sortPositionList.get(position2).split("-")[1]));

                BUY_AMOUNT = BUY_AMOUNT - 20;
                if (BUY_AMOUNT < 0) {
                    Log.e("buyMap", "buyPositionMap " + "------------------:" + sortPositionList.get(position1) + "+" + sortPositionList.get(position2) + "-trem:" + trem);
                } else {
                    Log.e("buyMap", "buyPositionMap " + "+++++++++++++++++++:" + sortPositionList.get(position1) + "+" + sortPositionList.get(position2) + "-trem:" + trem);
                }
            } else {
                BUY_AMOUNT = BUY_AMOUNT - 20;
                buyNumMap.put(Integer.parseInt(sortPositionList.get(position1).split("-")[0]), Integer.parseInt(sortPositionList.get(position1).split("-")[1]));
                buyNumMap.put(Integer.parseInt(sortPositionList.get(position2).split("-")[0]), Integer.parseInt(sortPositionList.get(position2).split("-")[1]));
                if (BUY_AMOUNT < 0) {
                    Log.e("buyMap", "buyNumMap " + "------------------:" + sortPositionList.get(position1) + "+" + sortPositionList.get(position2) + "-trem:" + trem);
                } else {
                    Log.e("buyMap", "buyNumMap " + "+++++++++++++++++++:" + sortPositionList.get(position1) + "+" + sortPositionList.get(position2) + "-trem:" + trem);
                }
            }

            Log.e("BUY_AMOUNT", "BUY_AMOUNT-: " + BUY_AMOUNT + "-trem:" + trem);

            if (LESS_AMOUNT > BUY_AMOUNT) {
                LESS_AMOUNT = BUY_AMOUNT;
            }
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

                    Log.e("********size~~~" + term, ",位置：" + (i + 1) + ",数字：" + (j + 1) + "---" + positionList.get(i)[j] + ",blank:" + blank);

                    if (blank <= MAX_2) {
                        if (trueMap.get(i * 10 + j) == -1) {
                            difbuyCount++;
                        }
                        trueMap.put(i * 10 + j, blank);
                    }
                }
            }

        }
    }

    private void setDifLastMap(int term) {


        Iterator<Map.Entry<Integer, Integer>> iterator = trueMap.entrySet().iterator();
        difBuyStr = "";
        while (iterator.hasNext()) {
            Map.Entry<Integer, Integer> next = iterator.next();
            lastPositionMap.put(next.getKey(), next.getValue());
            if (next.getValue() != -1) {
                difBuyStr = difBuyStr + "\n" + "位置:" + next.getKey() + "blank:" + next.getValue();
            }
//            if (next.getValue() > 0) {
//                Log.e("!!!!!!!!!!!!", "setLastMap: ");
//            }
        }
        if (!TextUtils.isEmpty(difBuyStr)) {
            Log.e("difBuyStr", "difBuyStr: " + difBuyStr + "----term:" + term);
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
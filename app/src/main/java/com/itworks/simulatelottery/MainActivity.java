package com.itworks.simulatelottery;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    private Button tvResult;
    private int allcount;
    private ArrayList<int[]> positionList;
    private ArrayList<int[]> numList;
    private ArrayList<int[]> templepositionList;
    private ArrayList<int[]> templenumList;
    private ArrayList<ArrayList<Integer>> allLists;
    private int BLANK_INT = 110;
    private int BEGIN_INT = 200;
    private EditText et_blank;
    private int LAST_SIZE = -1;
    private int BLANK_COUNT = -1;


    private void initBaseData() {

        if (null == allLists) {
            allLists = new ArrayList<>();
        }

        positionList = initList();
        numList = initList();
        templepositionList = initList();
        templenumList = initList();

    }

    private ArrayList<int[]> initList() {
        ArrayList<int[]> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            int[] ints = new int[10];
            for (int j = 0; j < 10; j++) {
                ints[j] = 0;
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

    private void getLotteryResult() {
        allcount = 0;
        LAST_SIZE = -1;
        String blank = et_blank.getText().toString();
        if (!TextUtils.isEmpty(blank)) {
            BLANK_INT = Integer.parseInt(blank);
        }

        Log.e("BLANK_INT", "BLANK_INT: " + BLANK_INT);

        initBaseData();

        for (int m = 0; m < 1; m++) {
            for (int j = 0; j < 20000; j++) {
                getProgress(j);
                ArrayList<Integer> integers = new ArrayList<>();
                Set<Integer> resultSet = generateRandomArray(10);
                Iterator<Integer> it = resultSet.iterator();


                if (j > BEGIN_INT) {
                    initBaseData();
                    caculateBlankData(j);
                }



                //result
                while (it.hasNext()) {
                    integers.add(it.next());
                }
                allLists.add(integers);
            }

        }

        Log.e("", "getLotteryResult: " + allcount);



    }

    private void getProgress(final int j) {

        this. runOnUiThread(new Runnable() {
            @Override
            public void run() {
                tvResult.setText(j + "");
            }
        });
    }

    private void caculateBlankData(int size) {
        getBlankDate(BLANK_INT, size);
    }

    private void getBlankDate(int blank, int size) {
        for (int i = 0; i < allLists.size(); i++) {
            for (int j = 0; j < 10; j++) {
                getPositionData(allLists.get(i).get(j), j);
            }
        }
        for (int i = 0; i < allLists.size()-blank; i++) {
            for (int j = 0; j < 10; j++) {
                getTemplePositionData(allLists.get(i).get(j),j);
            }
        }
        for (int i = 0; i < positionList.size(); i++) {
            for (int j = 0; j < 10; j++) {
                if (positionList.get(i)[j] == templepositionList.get(i)[j]) {
                    //begin
                    allcount++;
                    if ((-1 != LAST_SIZE && (size - LAST_SIZE) > 1) || -1 == LAST_SIZE) {
                        BLANK_COUNT = allcount;
                        Log.e("LAST_SIZE", "size:" + size + ",getBlankDateAllcount: " + allcount + ",blank:" + (blank) + ",位置：" + (i + 1) + ",数字：" + (j + 1));
                    }

                    Log.e("allcount", "size:" + size + ",getBlankDateAllcount: " + allcount + ",blank:" + (BLANK_INT + allcount - BLANK_COUNT));
                    LAST_SIZE = size;
                }
            }
        }

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

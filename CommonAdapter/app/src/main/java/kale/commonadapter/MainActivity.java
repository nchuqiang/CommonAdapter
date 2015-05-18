package kale.commonadapter;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.ActionBarActivity;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import kale.adapter.AdapterItem;
import kale.adapter.CommonAdapter;
import kale.commonadapter.item.ButtonItem;
import kale.commonadapter.item.ImageItem;
import kale.commonadapter.item.TextItem;
import kale.commonadapter.model.TestModel;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<TestModel> data = loadData();

        ListView listView = (ListView) findViewById(R.id.listView);
        listView.setAdapter(new CommonAdapter<TestModel>(data) {

            @NonNull
            @Override
            protected AdapterItem initItemView(int type) {
                AdapterItem item;
                switch (type) {
                    case TestModel.TYPE_TEXT:
                        item = new TextItem();
                        break;
                    case TestModel.TYPE_BUTTON:
                        item = new ButtonItem();
                        break;
                    case TestModel.TYPE_IMAGE:
                        item = new ImageItem();
                        break;
                    default:
                        item = new TextItem();
                }
                return item;
            }
        });
    }

    private final String TAG = getClass().getSimpleName();
    
    /**
     * 模拟加载数据的操作
     */
    private List<TestModel> loadData() {
        List<TestModel> list = new ArrayList<>();
        for (int i = 0; i < 20; i++) {
            int type = (int) (Math.random() * 3);
            //Log.d(TAG, "type = " + type);
            TestModel model = new TestModel();
            switch (type) {
                case 0:
                    model.setType("text");
                    model.setContent("第一种布局");
                    break;
                case 1:
                    model.setType("button");
                    model.setContent("第二种布局");
                    break;
                case 2:
                    model.setType("image");
                    model.setContent(String.valueOf(R.drawable.kale));
                    break;
                default:
            }
            list.add(model);
        }
        return list;
    }

}

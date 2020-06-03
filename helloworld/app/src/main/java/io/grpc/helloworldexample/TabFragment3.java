package io.grpc.helloworldexample;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import static android.content.Intent.getIntent;


public class TabFragment3 extends Fragment {

    public TabFragment3(){
        //dfdgf
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.tab_fragment3, container, false);

        // Inflate the layout for this fragment
        return v;
    }

}

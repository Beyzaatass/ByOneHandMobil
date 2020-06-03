package io.grpc.helloworldexample;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;


public class TabFragment2 extends Fragment {

    String[] ilanbaslik={"Burs","Hayvan","İhtiyaç","Kıyafet"};
    String[] ilanbilgi={"Burs fkdgnvj kfdngvi fdngfdjm ngükpıvm üfdpbıgkfd pongpıs fdomjgvı","Hayvan lksdnfcolk sdnfıpoh sgfdpıos ghnsdnp gınjsgdh fıspdn","İhtiyaç skdfnsdkli ofnkıons dfınadpıfn pdaınfıso dnfıjsndfpj sdpjfpsıdj fsfdfgdnjfısdn","Kıyafet dfgfdgkdnksd sdkfnsdnhfsa sjknfsdnfokda sdncfsdjnf skjnfdjsndjf jksdfbjdsbn jsdbfkjsdbn"};
    Integer[] imgid={R.drawable.burs, R.drawable.hayvan, R.drawable.ihtiyac,R.drawable.kiyafet,};

    public TabFragment2(){
        //dfgdfgs
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.tab_fragment2, container, false);

        ListView ilanlar=(ListView) v.findViewById(R.id.listView2);
        CustomListview customListview=new CustomListview(getActivity(),ilanbaslik,ilanbilgi,imgid);
        ilanlar.setAdapter(customListview);

        return v;
    }

}

package com.akshobhya.librehealth.Fragment;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.akshobhya.librehealth.Adapter.HospitalListAdapter;
import com.akshobhya.librehealth.R;

import java.util.ArrayList;

public class HospitalsFragment extends Fragment {

    RecyclerView rv;
    Spinner spinner_hospital;
    Context context;
    ArrayList<String> list_name = new ArrayList<String>();
    ArrayList<String> list_address = new ArrayList<String>();
    ArrayList<String> list_contact = new ArrayList<String>();
    HospitalListAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_hospitals, container, false);
        rv = view.findViewById(R.id.recyclerview_fragment_hospital);
        spinner_hospital = view.findViewById(R.id.spinner_hospital);
        context = getActivity();
        rv.setLayoutManager(new LinearLayoutManager(context));
        adapter = new HospitalListAdapter(context, list_name, list_address, list_contact);
        initSpinner();
        rv.setAdapter(adapter);
        return (view);
    }

    void refresh_rv() {
        adapter.notifyDataSetChanged();
    }

    public void initSpinner() {
        String[] items = new String[]{"Nairobi", "Mombasa", "Kisumu",};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_dropdown_item, items);
        spinner_hospital.setAdapter(adapter);
        spinner_hospital.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    data_placer_1();
                    refresh_rv();
                } else if (position == 1) {
                    data_placer_2();
                    refresh_rv();
                } else {
                    data_placer_3();
                    refresh_rv();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                // TODO Auto-generated method stub
            }
        });
    }


    public void data_placer_1() {
        list_name.clear();
        list_address.clear();
        list_contact.clear();
        list_name.add("The Nairobi Hospital Cancer Centre");
        list_address.add("The Nairobi Hospital Cancer Centre,P O 30026, Argwings Kodhek Rd, Kenya");
        list_contact.add("+254 20 2845000");
        list_name.add("The Aga Khan University Hospital");
        list_address.add("The Aga Khan University Hospital,3rd Parklands Avenue, Nairobi, Kenya");
        list_contact.add("+254 20 3662000");
        list_name.add("M.P Shah Hospital");
        list_address.add("M.P Shah Hospital,Shivaji Road, Nairobi, Kenya");
        list_contact.add("+254 20 4291100");
        list_name.add("The Nairobi West Hospital Ltd.");
        list_address.add("The Nairobi West Hospital Ltd.,Gandhi Ave, Nairobi, Kenya");
        list_contact.add("+254 730 600000");
        list_name.add("Avenue Hospital Nairobi");
        list_address.add("Avenue Hospital Nairobi,First Parklands Avenue, Kenya");
        list_contact.add("+254 732 175000");
    }

    public void data_placer_2() {
        list_name.clear();
        list_address.clear();
        list_contact.clear();
        list_name.add("The Mombasa Hospital");
        list_contact.add("+254 41 2312191");
        list_address.add("The Mombasa Hospital,Kizingo, Mombasa, Kenya");
        list_name.add("Aga Khan Hospital, Mombasa");
        list_contact.add("+254 41 5051000");
        list_address.add("Aga Khan Hospital,Vanga Rd, Mombasa, Kenya");
        list_name.add("Coast General Teaching & Referral Hospital");
        list_contact.add("+254 758 722001");
        list_address.add("Coast General Teaching & Referral Hospital,Kisauni Road Tononoka Mvita Mombasa KE, Kenya");
        list_name.add("The Nyali Children and Women Hospital");
        list_contact.add("+254 726 963178");
        list_address.add("The Nyali Children and Women Hospital, 43354- 80100 Mombasa KE, Kenya");
        list_name.add("PREMIER HOSPITAL");
        list_contact.add("+254 41 5011500");
        list_address.add("PREMIERE HOSPITAL,Links Rd, Mombasa, Kenya");
    }

    public void data_placer_3() {
        list_name.clear();
        list_address.clear();
        list_contact.clear();
        list_name.add("Kisumu County Referral Hospital");
        list_contact.add("+254 710 286818");
        list_address.add("Kisumu County Referral Hospital,Angawa Avenue Market Milimani Kisumu Central Kisumu KE, Kenya");
        list_name.add("Jaramogi Oginga Odinga Teaching & Referral Hospital");
        list_contact.add("+254 758 721994");
        list_address.add("Jaramogi Oginga Odinga Teaching & Referral Hospital,Jomo Kenyatta Highway Kaloleni Kisumu KE, Central, Kenya");
        list_name.add("Kilimani Hospital");
        list_contact.add("+254 738 008715");
        list_address.add("Kilimani Hospital,Kisumu, Kenya");
        list_name.add("Avenue Hospital Kisumu");
        list_contact.add("+254 718 860200");
        list_address.add("Avenue Hospital Kisumu,Kisumu - Kakamega Road, Opposite Kibuye Market, Keny");
        list_name.add("St. Jairus Hospital");
        list_contact.add("+254 716 258129");
        list_address.add("St. Jairus Hospital,Kisumu,Krnya");
    }
}
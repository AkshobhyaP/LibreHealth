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

public class DoctorsFragment extends Fragment {

    RecyclerView rv;
    Spinner spinner_doctor;
    Context context;
    ArrayList<String> list_name = new ArrayList<String>();
    ArrayList<String> list_address = new ArrayList<String>();
    ArrayList<String> list_contact = new ArrayList<String>();
    HospitalListAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_doctors, container, false);
        rv = view.findViewById(R.id.recyclerview_fragment_doctor);
        spinner_doctor = view.findViewById(R.id.spinner_doctor);
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
        String[] items = new String[]{"Child Specialist", "Dentist", "Psychologist",};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_dropdown_item, items);
        spinner_doctor.setAdapter(adapter);
        spinner_doctor.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
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
        list_name.add("DR. DAVID GITHANGA");list_contact.add("0722-524359");list_address.add(" Doctors' Plaza, Nairobi Hospital, Room 302. P.O. Box 19601-00202");
        list_name.add("DR. C. A. YUKO JOWI");list_contact.add("0722200512");list_address.add("HURLINGHAM HEART CLINIC. 5th Avenue House, 2nd Floor, Suite No. 4, 5th Avenue Road off Ngong Rd. P.O. Box 19624-00202");
        list_name.add("DR. NAOMI GACHARA");list_contact.add("0732593078");list_address.add("Nairobi Hospital, Doctors' Plaza, Room 208. P.O. Box 52244-00200");
        list_name.add("DR. GACHERI NELLY MUTUA");list_contact.add("0722787186");list_address.add("Nairobi Hospital, Doctors' Plaza, Argwings Kodhek Rd., 3rd Floor, Room 303");
        list_name.add("DR. CHARLES R. OPONDO");list_contact.add("020-2224225");list_address.add("Corner House, Mezz 3, Kimathi Street. P.O. Box 57097-00200 Nairobi");
    }

    public void data_placer_2() {
        list_name.clear();
        list_address.clear();
        list_contact.clear();
        list_name.add("NAIROBI PREMIER DENTAL CLINIC");list_contact.add("+254 701 859649");list_address.add("NAIROBI PREMIER DENTAL CLINIC, Kimathi St, Nairobi, Kenya");
        list_name.add("The Periodontist Dental Centre");list_contact.add("+254 716 521043");list_address.add("Apartment B8, Starwood Apartments, Argwings Kodhek Road. Hurlingham, Nairobi, Kenya");
        list_name.add("Molars Dental Clinic");list_contact.add("+254 751 856900");list_address.add("Molars Dental Clinic,Electricity House, 3rd Floor, Harambee Ave, Nairobi, Kenya");
        list_name.add("Dental Smiles");list_contact.add("+254 706 575276");list_address.add("Dental Smiles, One Padmore Place, George Padmore Road, Nairobi, Kenya");

    }

    public void data_placer_3() {
        list_name.clear();
        list_address.clear();
        list_contact.clear();
        list_name.add("Dr. Catherine Gacutha");list_contact.add("0723 891555");list_address.add("Dr. Catherine Gacutha,Southern Credit Bldg ‐ 5th Flr. Moi Av. Opp. Meridan Ht.");
        list_name.add("Dr. Gladys Mwiti");list_contact.add("020 271 5023");list_address.add("Dr. Gladys Mwiti,Hurlingharm ‐ Oasis Counseling Services");
        list_name.add("Dr.Debra Schoeherr Malik");list_contact.add("0733 730503");list_address.add("Dr.Debra Schoeherr Malik, Farasi Lane Off Kabete RD");
        list_name.add("Margaret Kitsusa");list_contact.add("0722 931 548");list_address.add("Margaret Kitsusa,Buruburu Business Complex bldg, 3rd Fl Near Kenya National Library");
        list_name.add("Alice Branchard");list_contact.add("0787567102");list_address.add("Alice Branchard,Westlands; Grevillea Grove");
    }
}
package greenwich.vn.test4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class FormActivity extends AppCompatActivity {

    String[] types = {"Flat", "House", "Pen House", "Bungalow"};
    String[] furniture = {"Furnished", "Unfurnished", "Part-furnished"};
//    getResources().getStringArray(R.array.types)

    AutoCompleteTextView autoCompleteTypeTextView;
    AutoCompleteTextView autoCompleteFurnitureTextView;

    ArrayAdapter<String> adapterTypeItems;
    ArrayAdapter<String> adapterFurnitureItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_property);


        autoCompleteTypeTextView = findViewById(R.id.selectType);
        autoCompleteFurnitureTextView = findViewById(R.id.selectFurniture);
        adapterTypeItems = new ArrayAdapter<String>(this, R.layout.list_item, types);
        adapterFurnitureItems = new ArrayAdapter<String>(this, R.layout.list_item, furniture);
        autoCompleteTypeTextView.setAdapter(adapterTypeItems);
        autoCompleteFurnitureTextView.setAdapter(adapterFurnitureItems);
        autoCompleteTypeTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String type = parent.getItemAtPosition(position).toString();
                Toast.makeText(getApplicationContext(), "Type: "+type, Toast.LENGTH_SHORT).show();
            }
        });
        autoCompleteFurnitureTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String furniture = parent.getItemAtPosition(position).toString();
                Toast.makeText(getApplicationContext(), "Furniture: "+furniture, Toast.LENGTH_SHORT).show();
            }
        });

//        String btnNextName = getResources().getString(R.string.tv_nextBtn);
        Button btnNextForm = findViewById(R.id.btnCreate);
        btnNextForm.setOnClickListener(_btnNextClick);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }
    private View.OnClickListener _btnNextClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            boolean isValid = true;
            TextView tvErrorRentalName = findViewById(R.id.tvErrorRentalNameTest);
            TextView tvErrorNameReported = findViewById(R.id.tvErrorNameReportTest);
            TextView tvErrorAddress = findViewById(R.id.tvErrorAddress);
            TextView selectErrorType = findViewById(R.id.selectErrorType);
            TextView selectErrorFurniture = findViewById(R.id.selectErrorFurniture);
            TextView tvErrorBed = findViewById(R.id.tvErrorNumBed);
            TextView tvErrorPrice = findViewById(R.id.tvErrorPrice);

            TextView tvRentalName = findViewById(R.id.textName);
            TextView tvNameReporter = findViewById(R.id.textReporter);
            TextView tvAddress = findViewById(R.id.textAddress);
            TextView selectType = findViewById(R.id.selectType);
            TextView selectFurniture = findViewById(R.id.selectFurniture);
            TextView tvNumBed = findViewById(R.id.textBedroom);
            TextView tvPrice = findViewById(R.id.textPrice);
            TextView tvNote = findViewById(R.id.textNote);

            String rentalName = tvRentalName.getText().toString();
            String nameReporter = tvNameReporter.getText().toString();
            String address = tvAddress.getText().toString();
            String type = selectType.getText().toString();
            String furniture = selectFurniture.getText().toString();
            String numBed = tvNumBed.getText().toString();
            String price = tvPrice.getText().toString();
            String numNote = tvNote.getText().toString();

            String errorRentalName = "";
            String errorNameReporter = "";
            String errorAddress = "";
            String errorSelectType = "";
            String errorSelectFurniture = "";
            String errorNumBed = "";
            String errorPrice = "";
            if(TextUtils.isEmpty(rentalName)){
                isValid = false;
                errorRentalName += "* The field can't be empty. Please enter rental name!*";
            }
            if(TextUtils.isEmpty(nameReporter)){
                isValid = false;
                errorNameReporter += "* The field can't be empty. Please enter name reporter!*";
            }
            if(TextUtils.isEmpty(address)){
                isValid = false;
                errorAddress += "* The field can't be empty. Please enter address!*";
            }
                        if(TextUtils.isEmpty(type)){
                isValid = false;
                errorSelectType += "* The field must be select property type!*";
            }
            if(TextUtils.isEmpty(furniture)){
                isValid = false;
                errorSelectFurniture += "* The field must be select property furniture!*";
            }
            if(TextUtils.isEmpty(numBed)){
                isValid = false;
                errorNumBed += "* The field can't be empty. Please enter No.Bedroom!*";
            }
            if(TextUtils.isEmpty(price)){
                isValid = false;
                errorPrice += "* The field can't be empty. Please enter your price!*";
            }
            if (isValid){
                Bundle bundle = new Bundle();
                bundle.putString("rentalName", rentalName);
                bundle.putString("nameReporter", nameReporter);
                bundle.putString("address", address);
                bundle.putString("type", type);
                bundle.putString("furniture", furniture);
                bundle.putString("numBed", numBed);
                bundle.putString("price", price);
                bundle.putString("note", numNote);
                Intent putText = new Intent(v.getContext(), ConfirmActivity.class);
                putText.putExtras(bundle);
                startActivity(putText);
            }
            else{
                tvErrorRentalName.setText(errorRentalName);
                tvErrorNameReported.setText(errorNameReporter);
                tvErrorAddress.setText(errorAddress);
                selectErrorType.setText(errorSelectType);
                selectErrorFurniture.setText(errorSelectFurniture);
                tvErrorBed.setText(errorNumBed);
                tvErrorPrice.setText(errorPrice);
            }
        }
    };

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}
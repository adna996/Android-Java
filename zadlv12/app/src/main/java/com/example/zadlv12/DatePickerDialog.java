package com.example.zadlv12;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.DatePicker;
import android.widget.NumberPicker;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;


public class DatePickerDialog extends DialogFragment{


    public DatePickerDialog(FragmentActivity activity, DatePickerFragment datePickerFragment, int year, int month, int day) {
    }

    public interface OnDateSetListener {
        void onDateSet(DatePicker view, int year, int month, int dayOfMonth);
    }

    public interface OnDateSet {
        void onDateSet(DatePicker view, int year, int month, int dayOfMonth);

    }
}

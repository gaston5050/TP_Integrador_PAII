package com.example.tp_integrador_paii.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.tp_integrador_paii.R;
import com.example.tp_integrador_paii.entidad.Hora_Semanal;

import java.util.List;

public class HoraSemanalSpinnerAdapter extends ArrayAdapter<Hora_Semanal> {
    public HoraSemanalSpinnerAdapter(Context context, List<Hora_Semanal> objects) {
        super(context, R.layout.spiner_template_default, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View view = inflater.inflate(R.layout.spiner_template_default, null);

        TextView tvId = view.findViewById(R.id.tv_id_spiner_default);
        TextView tvDescripcion = view.findViewById(R.id.tv_decripcion_spiner_default);

        tvId.setText(getItem(position).getId().toString());
        tvDescripcion.setText(getItem(position).getDescripcion());

        return view;
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View view = inflater.inflate(R.layout.spiner_template_default, null);

        TextView tvId = view.findViewById(R.id.tv_id_spiner_default);
        TextView tvDescripcion = view.findViewById(R.id.tv_decripcion_spiner_default);

        tvId.setText(getItem(position).getId().toString());
        tvDescripcion.setText(getItem(position).getDescripcion());

        return view;
    }
}

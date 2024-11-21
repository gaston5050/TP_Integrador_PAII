package com.example.tp_integrador_paii.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.tp_integrador_paii.R;
import com.example.tp_integrador_paii.entidad.Encuesta;

import java.util.List;

public class EncuestaListAdapter extends ArrayAdapter<Encuesta> {

    public EncuestaListAdapter(Context context, List<Encuesta> objetos) {
        super(context, R.layout.list_template_encuesta, objetos);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.list_template_encuesta, null);

        TextView txtId = item.findViewById(R.id.txtId);
        TextView txtSexo = item.findViewById(R.id.txtSexo);
        TextView txtEstudio = item.findViewById(R.id.txtEstudio);
        TextView txtEdad = item.findViewById(R.id.txtEdad);
        TextView txtTrabajo = item.findViewById(R.id.txtTrabajo);
        TextView txtRelacionContractual = item.findViewById(R.id.txtRelacionContractual);
        TextView txtRubro = item.findViewById(R.id.txtRubro);
        TextView txtHoraSemanal = item.findViewById(R.id.txtHoraSemanal);
        TextView txtAntiguedad = item.findViewById(R.id.txtAntiguedad);
        TextView txtSalario = item.findViewById(R.id.txtSalario);
        TextView txtConforme = item.findViewById(R.id.txtConforme);
        TextView txtEncuestador = item.findViewById(R.id.txtEncuestador);

        txtId.setText(getItem(position).getId().toString());
        txtSexo.setText(getItem(position).getId_sexo().getDescripcion());
        txtEstudio.setText(getItem(position).getId_estudio().getDescripcion());
        txtEdad.setText(getItem(position).getId_edad().getDescripcion());
        txtTrabajo.setText(getItem(position).getId_trabajo().getDescripcion());
        txtRelacionContractual.setText(getItem(position).getId_relacion_contractual().getDescripcion());
        txtRubro.setText(getItem(position).getId_rubro().getDescripcion());
        txtHoraSemanal.setText(getItem(position).getId_hora_semanal().getDescripcion());
        txtAntiguedad.setText(getItem(position).getId_antiguedad().getDescripcion());
        txtSalario.setText(getItem(position).getId_salario().getDescripcion());
        txtConforme.setText(getItem(position).getId_conforme().getDescripcion());
        txtEncuestador.setText(getItem(position).getId_encuestador().getCue());

        return item;
    }
}

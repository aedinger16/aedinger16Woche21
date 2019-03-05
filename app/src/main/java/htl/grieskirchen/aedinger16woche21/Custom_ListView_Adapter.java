package htl.grieskirchen.aedinger16woche21;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class Custom_ListView_Adapter extends ArrayAdapter<Rechnung> {

    List<Rechnung> rechnungen;
    Context context;
    int resource;

    public Custom_ListView_Adapter(Context context, int resource, List<Rechnung> rechnungen) {
        super(context, resource, rechnungen);
        this.context = context;
        this.resource = resource;
        this.rechnungen = rechnungen;
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    @NonNull
    @Override
    public View getView(final int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater layoutInflater = LayoutInflater.from(context);

        View view = layoutInflater.inflate(resource, null, false);

        TextView textViewMessage = view.findViewById(R.id.textViewMessage);
        TextView textViewAOE = view.findViewById(R.id.textViewAOE);
        Button buttonDelete = view.findViewById(R.id.buttonDelete);

        Rechnung rechnung = rechnungen.get(position);

        textViewMessage.setText(rechnung.toString());
        textViewAOE.setText(rechnung.getIncomeOrExpenditure());

        buttonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                removeHero(position);
            }
        });

        return view;
    }

    private void removeHero(final int position) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle("Sicher, dass du diesen Eintrag löschen möchtest?");

        builder.setPositiveButton("Ja", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                rechnungen.remove(position);

                notifyDataSetChanged();
            }

        });

        builder.setNegativeButton("Abbrechen", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }
}

package acf.com.br.provasufsc;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;

public class MeusResultados extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meus_resultados);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        meusResultados();
    }

    private void meusResultados(){
        TextView totalSimuladosFeitos = (TextView) findViewById(R.id.txtTotalSimuladoFeito);
        totalSimuladosFeitos.setText(read(ClassesStaticas.totalSimuladoFeitoFile));

        TextView percentualAcertoSimulados = (TextView) findViewById(R.id.txtPercentualAcertoTotal);
        totalSimuladosFeitos.setText(read(ClassesStaticas.totalSimuladoFeitoFile));

        TextView percentualAcertoPT= (TextView) findViewById(R.id.txtPercentualAcertoPT);
        percentualAcertoSimulados.setText(getPercentual(ClassesStaticas.qtdeQuestoesTotalCertoFile,ClassesStaticas.qtdeQuestoesTotalFile)+"%");

        TextView percentualAcertoMTM= (TextView) findViewById(R.id.txtPercentualMTM);
        percentualAcertoMTM.setText(getPercentual(ClassesStaticas.totalAcertosMTM,ClassesStaticas.totalQuestoesMTM)+"%");

        TextView percentualAcertoEspahol= (TextView) findViewById(R.id.txtPercentualEspanhol);
        percentualAcertoEspahol.setText(getPercentual(ClassesStaticas.totalAcertosESP,ClassesStaticas.totalQuestoesESP)+"%");

        TextView percentualAcertoFisica= (TextView) findViewById(R.id.txtPercentualFisica);
        percentualAcertoFisica.setText(getPercentual(ClassesStaticas.totalAcertosFIS,ClassesStaticas.totalQuestoesFIS)+"%");

        TextView percentualAcertoFisicaGeografia= (TextView) findViewById(R.id.txtPercentualGeografia);
        percentualAcertoFisicaGeografia.setText(getPercentual(ClassesStaticas.totalAcertosGEO,ClassesStaticas.totalQuestoesGEO)+"%");

        TextView percentualAcertoHistoria= (TextView) findViewById(R.id.txtPercentualHistoria);
        percentualAcertoHistoria.setText(getPercentual(ClassesStaticas.totalAcertosHIST,ClassesStaticas.totalQuestoesHIST)+"%");

        TextView percentualAcertoHistoriaIngles= (TextView) findViewById(R.id.txtPercentualIngles);
        percentualAcertoHistoriaIngles.setText(getPercentual(ClassesStaticas.totalAcertosING,ClassesStaticas.totalQuestoesING)+"%");

        TextView percentualAcertoHistoriaQuimica= (TextView) findViewById(R.id.txtPercentualQuimica);
        percentualAcertoHistoriaQuimica.setText(getPercentual(ClassesStaticas.totalAcertosQMC,ClassesStaticas.totalQuestoesQMC)+"%");

    }

    private int getPercentual(String variavelAcerto, String variavelTotal){
        String totPT = read(variavelTotal);
        Integer totalPT = totPT!= null?Integer.parseInt(totPT):0;
        String totAcertoPT = read(variavelAcerto);
        Integer totalAcertoPT = totAcertoPT!= null?Integer.parseInt(totAcertoPT):0;
        Integer percentualPT = totalPT>0?(totalAcertoPT*100/totalPT):0;
        return percentualPT;
    }

    public String read(String file){
        try{
            FileInputStream fin = openFileInput(file);
            int c;
            String temp="";
            while( (c = fin.read()) != -1){
                temp = temp + Character.toString((char)c);
            }

            return temp;

        }catch(Exception e){
            return null;
        }

    }

}

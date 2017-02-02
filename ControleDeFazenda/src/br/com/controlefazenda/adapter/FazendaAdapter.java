package br.com.controlefazenda.adapter;

import java.util.List;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import br.com.controlefazenda.R;
import br.com.controlefazenda.vo.FazendaVO;

public class FazendaAdapter extends BaseAdapter {
	private LayoutInflater inflater = null;
	private List<FazendaVO> fazendas = null;
	private ViewHolder holder = null;

	static class ViewHolder {
		public TextView txtCodigo;
		public TextView txtDescricao;
		public TextView txtProprietario;
	}
	public FazendaAdapter(Context context, List<FazendaVO> fazendas) {
		inflater = LayoutInflater.from(context);
		this.fazendas = fazendas;
	}

	@Override
	public int getCount() {
		return fazendas.size();
	}

	@Override
	public Object getItem(int position) {
		return fazendas.get(position);
	}

	@Override
	public long getItemId(int position) {
		return fazendas.get(position).getCodigo();
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if (convertView == null) {
			convertView = inflater.inflate(R.layout.listar_fazenda, null);

			holder = new ViewHolder();
			holder.txtCodigo = (TextView) convertView.findViewById(R.id.txtCodigo);
			holder.txtDescricao = (TextView) convertView.findViewById(R.id.txtDescricao);
			holder.txtProprietario = (TextView) convertView.findViewById(R.id.txtProprietario);
		
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}

		FazendaVO fazenda = fazendas.get(position);
		holder.txtCodigo.setText(Long.toString(fazenda.getCodigo()));
		holder.txtDescricao.setText(fazenda.getDescricao());
		holder.txtProprietario.setText(fazenda.getProprietario());
		
		return convertView;
	}
}

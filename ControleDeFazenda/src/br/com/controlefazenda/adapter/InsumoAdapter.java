package br.com.controlefazenda.adapter;

import java.util.List;

import br.com.controlefazenda.R;
import br.com.controlefazenda.vo.InsumoVO;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class InsumoAdapter extends BaseAdapter {
	private LayoutInflater inflater = null;
	private List<InsumoVO> insumos = null;
	private ViewHolder holder = null;

	static class ViewHolder {
		public TextView lblCodigoInsumo;
		public TextView lblDescricaoAbreviadaInsumo;
		public TextView lblDescricaoInsumo;
		public ImageView imgInsumo;
	}
	
	public InsumoAdapter(Context context, List<InsumoVO> insumos) {
		inflater = LayoutInflater.from(context);
		this.insumos = insumos;
	}

	@Override
	public int getCount() {
		return insumos.size();
	}

	@Override
	public Object getItem(int position) {
		return insumos.get(position);
	}

	@Override
	public long getItemId(int position) {
		return insumos.get(position).getCodigo();
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if (convertView == null) {
			convertView = inflater.inflate(R.layout.listar_insumo, null);

			holder = new ViewHolder();
			holder.lblCodigoInsumo = (TextView) convertView.findViewById(R.id.lblCodigoInsumo);
			holder.lblDescricaoAbreviadaInsumo = (TextView) convertView.findViewById(R.id.lblDescricaoAbreviadaInsumo);
			holder.lblDescricaoInsumo = (TextView) convertView.findViewById(R.id.lblDescricaoInsumo);
			holder.imgInsumo = (ImageView) convertView.findViewById(R.id.imgInsumo);
			
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}

		InsumoVO insumo = insumos.get(position);
		holder.lblCodigoInsumo.setText(Long.toString(insumo.getCodigo()));
		holder.lblDescricaoAbreviadaInsumo.setText(insumo.getDescricaoAbreviada());
		holder.lblDescricaoInsumo.setText(insumo.getDescricao());
		if(insumo.getQuantidadeDisponivel() >= 10){
			holder.imgInsumo.setImageResource(R.drawable.certo);
		}
		else holder.imgInsumo.setImageResource(R.drawable.aviso);
		
		return convertView;
	}

}

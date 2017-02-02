package br.com.controlefazenda.adapter;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import br.com.controlefazenda.R;
import br.com.controlefazenda.vo.FuncionarioVO;

public class FuncionarioAdapter extends BaseAdapter {
	private LayoutInflater inflater = null;
	private List<FuncionarioVO> funcionarios = null;
	private ViewHolder holder = null;

	static class ViewHolder {
		public ImageView imgSexo;
		public TextView lblMatricula;
		public TextView lblNome;
	}
	public FuncionarioAdapter(Context context, List<FuncionarioVO> funcionarios) {
		inflater = LayoutInflater.from(context);
		this.funcionarios = funcionarios;
	}

	@Override
	public int getCount() {
		return funcionarios.size();
	}

	@Override
	public Object getItem(int position) {
		return funcionarios.get(position);
	}

	@Override
	public long getItemId(int position) {
		return funcionarios.get(position).getMatricula();
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		if (convertView == null) {
			convertView = inflater.inflate(R.layout.listar_funcionario, null);

			holder = new ViewHolder();
			holder.imgSexo = (ImageView) convertView.findViewById(R.id.imgSexo);
			holder.lblMatricula = (TextView) convertView.findViewById(R.id.lblMatricula);
			holder.lblNome = (TextView) convertView.findViewById(R.id.lblNome);
			convertView.setTag(holder);
		} else {
			holder = (ViewHolder) convertView.getTag();
		}

		FuncionarioVO funcionario = funcionarios.get(position);
		holder.imgSexo.setImageResource("F".equalsIgnoreCase(funcionario.getSexo()) ? R.drawable.mulher : R.drawable.homem);
		holder.lblMatricula.setText(Long.toString(funcionario.getMatricula()));
		holder.lblNome.setText(funcionario.getNome());
		return convertView;
	}

}

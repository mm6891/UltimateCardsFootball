package gssports.ultimatecardsfootball;

public class CardFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.card, container, false);

        TextView tvName = (TextView) v.findViewById(R.id.tvName);
		TextView tvNumero = (TextView) v.findViewById(R.id.tvNumero);
		TextView tvDatos = (TextView) v.findViewById(R.id.tvDatos);
		TextView tvDemarcacion = (TextView) v.findViewById(R.id.tvDemarcacion);
		TextView tvAtributos = (TextView) v.findViewById(R.id.tvAtributos);
		
        tvName.setText(getArguments().getString("name"));

        return v;
    }

    public static CardFragment newInstance(String name) {

        CardFragment f = new CardFragment();
        Bundle b = new Bundle();
        b.putString("name", name);

        f.setArguments(b);

        return f;
    }
}
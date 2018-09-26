package com.ipartek.formacion.libro.model;

import java.util.ArrayList;
import java.util.List;

import com.ipartek.formacion.libro.pojo.Pagina;

public class PaginaArrayListDAO implements CrudAble<Pagina> {

	private static PaginaArrayListDAO INSTANCE = null;
	private static List<Pagina> paginas = null;

	private PaginaArrayListDAO() {
		paginas = new ArrayList<Pagina>();
		try {

			crearPagsMock();

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void crearPagsMock() {

		String textoWilliam = "Despues de algún tiempo aprenderás la diferencia entre dar la mano y socorrer a un alma, y aprenderás que amar no significa apoyarse, y que compañía no siempre significa seguridad.\n"
				+ "  Comenzarás a aprender que los besos no son contratos, ni regalos ni promesas… comenzarás a aceptar tus derrotas con la cabeza erguida y la mirada al frente, con la gracia de un niño y no con la tristeza de un adulto y aprenderás a construir hoy todos tus caminos, porque el terreno de mañana es incierto para tus proyectos y el futuro tiene la costumbre de caer en el vacío.";

		String textoPablo = "Muere lentamente quien no viaja, quien no lee, quien no escucha música o quien no se halla contento o encantado consigo mismo. Muere lentamente quien destruye su propio amor, quien no se deja ayudar.\n"
				+ "\n"
				+ "Muere lentamente quien evita la pasión y su remolino de emociones, aquellas emociones que rescatan el brillo de los ojos y de los corazones decaídos.\n"
				+ "\n"
				+ "Muere lentamente quien no cambia de vida cuando está insatisfecho con su trabajo o con su amor. Quien no arriesga lo seguro por lo incierto, quien no se permite, al menos una vez en su vida, huir de las razones sensatas.\n"
				+ "\n"
				+ "Por eso grito y quisiera que todos gritaran conmigo: vive hoy. Arriesga hoy. Haz hoy, y no te olvides de ser feliz o al menos de intentarlo";

		String textoCervantes = "Tanto cuanto el amor convida y llama\n" + "al alma con sus gustos de apariencia,\n"
				+ "tanto más huye su mortal dolencia\n" + "quien sabe el nombre que le da la fama.\n" + "\n"
				+ "Y el pecho opuesto a su amorosa llama,\n" + "armado de una honesta resistencia,\n"
				+ "poco puede empecerle su inclemencia,\n" + "poco su fuego y su rigor le inflama.\n" + "\n"
				+ "Segura está, quien nunca fue querida\n" + "ni supo querer bien, de aquella lengua\n"
				+ "que en su deshonra se adelgaza y lima;\n" + "\n" + "mas si el querer y el no querer da mengua,\n"
				+ "¿en qué ejercicios pasará la vida\n" + "la que más que al vivir la honra estima?";

		String textoPaulo = "Todos nosotros hemos pasado muchos días, o semanas enteras, sin recibir ningún gesto de cariño del prójimo. Son momentos difíciles, cuando el calor humano desaparece, y la vida se reduce a un arduo esfuerzo por sobrevivir.\n"
				+ "\n"
				+ "En esos momentos en que el fuego ajeno no le da calor a nuestra alma, debemos revisar nuestro propio hogar. Debemos agregarle más leña y tratar de iluminar la sala oscura en la que nuestra vida se transformó.\n"
				+ "\n"
				+ "Cuando escuchemos que nuestro fuego crepita, que la madera cruje, que las brasas brillan o las historias que las llamas cuentan, la esperanza nos será devuelta.\n"
				+ "\n"
				+ "Si somos capaces de amar, también seremos capaces de ser amados. No es más que cuestión de tiempo.";

		paginas.add(new Pagina(0, "Érase una vez", "Érase una vez...", "Anónimo"));
		paginas.add(new Pagina(1, "Aprenderás", textoWilliam, "William"));
		paginas.add(new Pagina(2, "Muere lentamente", textoPablo, "Pablo"));
		paginas.add(new Pagina(3, "Poema", textoCervantes, "Cervantes"));
		paginas.add(new Pagina(4, "Todos nosotros", textoPaulo, "Paulo"));

	}

	public static synchronized PaginaArrayListDAO getInstance() {
		if (INSTANCE == null) {
			INSTANCE = new PaginaArrayListDAO();
		}

		return INSTANCE;
	}

	@Override
	public boolean insert(Pagina pojo) {
		return paginas.add(pojo);
	}

	@Override
	public List<Pagina> getAll() {
		return paginas;
	}

	@Override
	public Pagina getById(long id) {
		Pagina resul = null;
		for (Pagina pag : paginas) {
			if (id == pag.getId()) {
				resul = pag;
			}
		}
		return resul;
	}

	@Override
	public boolean update(Pagina pojo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(String id) {
		boolean resul = false;
		Pagina pag = null;
		if (id != null) {
			for (int i = 0; i < paginas.size(); i++) {
				pag = paginas.get(i);
				if (id.equals(pag.getId())) {
					resul = paginas.remove(pag);
					break;
				}
			}
		}
		return resul;
	}

}

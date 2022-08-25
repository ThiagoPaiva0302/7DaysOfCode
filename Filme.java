import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Filme {
		
		private List<String> titulos = new LinkedList<>();
		private List<String> imagem = new LinkedList<>();
		private List<String> pontuacao = new LinkedList<>();
		private List<String> lancamento = new LinkedList<>();
		
		
		
		
		public Filme(List<String> titulos2, List<String> imagem, List<String> pontuacao, List<String> lancamento) {
			super();
			this.titulos = titulos2;
			this.imagem = imagem;
			this.pontuacao = pontuacao;
			this.lancamento = lancamento;
		}
		
		public String exibiFilme(List<String> titulo, List<String> imagem, List<String> pontuacao,int i) {
			
			return "Filme: " + titulo.get(i) + " Pontuacao: " + pontuacao.get(i) + " Imagem: " + imagem.get(i);
		}
		
		public List<String> getTitulos() {
			return titulos;
		}

		public void setTitulos(ArrayList<String> list) {
			this.titulos = list;
		}
		
		public List<String> getImagem() {
			return imagem;
		}
		public void setImagem(List<String> imagem) {
			this.imagem = imagem;
		}
		
		public List<String> getPontuacao() {
			return pontuacao;
		}
		public void setPontuacao(List<String> pontuacao) {
			this.pontuacao = pontuacao;
		}
		public List<String> getLancamento() {
			return lancamento;
		}
		public void setLancamento(List<String> lancamento) {
			this.lancamento = lancamento;
		}
		
		@Override
		public String toString() {
			
			return super.toString();
		}
		
	}
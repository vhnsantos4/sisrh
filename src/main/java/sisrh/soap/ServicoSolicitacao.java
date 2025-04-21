package sisrh.soap;

import javax.annotation.Resource;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.WebServiceContext;

import sisrh.banco.Banco;
import sisrh.dto.Solicitacoes;
import sisrh.seguranca.Autenticador;

@WebService
public class ServicoSolicitacao {
	
		@Resource
		WebServiceContext context;

		@WebMethod
		public Solicitacoes listarSolicitacoes(String usuario) throws Exception{
			Autenticador.autenticarUsuarioSenha(context);
			Solicitacoes resultado = new Solicitacoes();
			resultado.getSolicitacoes().addAll(Banco.listarSolicitacoes());
			return resultado;
		}
}

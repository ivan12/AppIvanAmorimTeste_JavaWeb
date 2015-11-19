package com.mkyong.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class BaseController {

	private String senhaGeradaCliente = "";
	private String senhaAtualChamadaGerente = "";	
	private String nomeGerente = "";
	private static final String VIEW_INDEX = "index";
	private static final String VIEW_GERENTE = "gerente";
	private final static org.slf4j.Logger logger = LoggerFactory.getLogger(BaseController.class);
	List<String> listaSenhasP = new ArrayList<String>();
	List<String> listaSenhasN = new ArrayList<String>();
	List<String> listaSenhasJaChamadas = new ArrayList<String>();
	int contSenhas = 0;
    
    
	public void retiradaSenhasAleatorias(int tipoSenha)
	{
	int cont = 0, b = 0, c = 0;
	String i ="";
	String [] Vetor = new String[7];

	String [] ArrayString ={"0","1","2","3","4","5","6","7","8","9"};

	for(c = 0; c < 4; c++)
	{	
	cont = (int)(Math.random()*ArrayString.length);

	for(b = 0; b <= ArrayString.length; b++)
	{

	if(b == cont)
	i = ArrayString[b];
	}


	Vetor[c] = i;
	i ="";
	}	

	String senha = "";
	String p1 = "";
	String p2 = "";
	String p3 = "";
	String p4 = "";

	p1 = Vetor[0];
	p2 = Vetor[1];
	p3 = Vetor[2];
	p4 = Vetor[3];

	if(tipoSenha == 1){
		senha += "P"+p1 + p2 + p3 + p4;
		listaSenhasP.add(senha);
	}else{
		senha += "N"+p1 + p2 + p3 + p4;
		listaSenhasN.add(senha);
	}
	senhaGeradaCliente = senha;

	}
	
	
	public void retiradaSenhas(int tipoSenha)
	{
	String i ="";
	
	contSenhas++;
	
	String senha = "";

	if(tipoSenha == 1){
		senha += "P"+String.format("%04d", contSenhas);
		listaSenhasP.add(senha);
	}else{
		senha += "N"+String.format("%04d", contSenhas);
		listaSenhasN.add(senha);
	}
	senhaGeradaCliente = senha;

	}
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String welcomePost(@RequestParam(required=false , value = "normal") String senhaNormal , 
			@RequestParam(required=false , value = "preferencial") String senhaPreferencial, ModelMap model) {


		if(senhaNormal != null){
			retiradaSenhas(2);
		}else{
			if(senhaPreferencial != null){
				retiradaSenhas(1);
			}
		}
		
		model.addAttribute("message", "Welcome");
		model.addAttribute("senhaGeradaCliente", senhaGeradaCliente);
		model.addAttribute("senhaAtualChamadaGerente", senhaAtualChamadaGerente);
		
		logger.debug("[welcomePost] senhaGeradaCliente : {}", senhaGeradaCliente);

		return VIEW_INDEX;
		
	}
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String welcome(ModelMap model) {

		model.addAttribute("message", "Welcome");
		model.addAttribute("senhaGeradaCliente", senhaGeradaCliente);
		model.addAttribute("senhaAtualChamadaGerente", senhaAtualChamadaGerente);
		
		logger.debug("[welcome] senhaGeradaCliente : {}", senhaGeradaCliente);

		return VIEW_INDEX;

	}

	@RequestMapping(value = "/{name}", method = RequestMethod.POST)
	public String welcomeNamePost(@PathVariable String name, 
			@RequestParam(required=false , value = "proxima") String proxima , 
			@RequestParam(required=false , value = "reiniciar") String reiniciar, ModelMap model) {
		
		nomeGerente = name;
		
		if(reiniciar != null){
			senhaAtualChamadaGerente = "";
			senhaGeradaCliente = "";
			contSenhas = 0;
			listaSenhasN.clear();
			listaSenhasP.clear();
			listaSenhasJaChamadas.clear();
		}else{
			if(proxima != null){
				if(listaSenhasP.size() > 0){
						senhaAtualChamadaGerente = ""+listaSenhasP.get(0);
						listaSenhasP.remove(0);
						listaSenhasJaChamadas.add(senhaAtualChamadaGerente);
				}else{
					if(listaSenhasN.size() > 0){
						senhaAtualChamadaGerente = ""+listaSenhasN.get(0);
						listaSenhasN.remove(0);
						listaSenhasJaChamadas.add(senhaAtualChamadaGerente);
					}else{
						senhaAtualChamadaGerente = "";
					}
				}
			}
		}
		model.addAttribute("nome", nomeGerente);
		model.addAttribute("senhaAtualChamadaGerente", senhaAtualChamadaGerente);
		model.addAttribute("listaSenhasN", listaSenhasN);
		model.addAttribute("listaSenhasP", listaSenhasP);
		
		logger.debug("[welcomeName] senhaAtual : {}", senhaAtualChamadaGerente);
		
		return VIEW_GERENTE;

	}
	
	@RequestMapping(value = "/{name}", method = RequestMethod.GET)
	public String welcomeName(@PathVariable String name, ModelMap model) {
        
		nomeGerente = name;
		
		model.addAttribute("nome", nomeGerente);
		model.addAttribute("senhaAtualChamadaGerente", senhaAtualChamadaGerente);
		model.addAttribute("listaSenhasN", listaSenhasN);
		model.addAttribute("listaSenhasP", listaSenhasP);
		
		logger.debug("[welcomeName] senhaAtual : {}", senhaAtualChamadaGerente);
		
		return VIEW_GERENTE;

	}

}
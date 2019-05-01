package com.dominio.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dominio.dto.ViagemDTO;
import com.dominio.entity.Viagem;
import com.dominio.repository.ViagemRepository;

@Service
public class ViagemService {
	
	@Autowired
	private ViagemRepository viagemRepository;

	public List<Viagem> listar() {
		return viagemRepository.findAll();
	}
	
	public Viagem salvar(ViagemDTO viagemDTO) {
		Viagem viagem = new Viagem();
		
		viagem.setLocalDeDestino(viagemDTO.getLocalDeDestino());
		viagem.setDataPartida(viagemDTO.getDataPartida());
		viagem.setDataRetorno(viagemDTO.getDataRetorno());
		viagem.setAcompanhante(viagemDTO.getAcompanhante());
		
		return viagemRepository.save(viagem);
	}

	public Viagem buscar(Long id) {
		
		// O MÉTODO PADRÃO DO REPOSITORY NÃ ESTAVA FUNCIONANDO CORRETAMENTE
		// FORÇADO PARA ELE TRAZER CORRETAMENTE OS DADOS PELO ID AO COMPARAR COM O INDEX DA LISTA
		String aux = String.valueOf(id);
		int index = Integer.parseInt(aux);
		Viagem viagem = viagemRepository.findAll().get(index - 1);
		
		return viagem;
	}
}

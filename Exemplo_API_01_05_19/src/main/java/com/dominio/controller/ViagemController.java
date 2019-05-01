package com.dominio.controller;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.dominio.dto.ViagemDTO;
import com.dominio.entity.Viagem;
import com.dominio.response.Response;
import com.dominio.service.ViagemService;

@RestController
@RequestMapping("/api/viagens")
public class ViagemController {
	
	@Autowired
	private ViagemService viagemService;
	
	@PostMapping(path = "/new")
	public ResponseEntity<Response<Viagem>> cadastrar(@Valid @RequestBody ViagemDTO viagemDTO, BindingResult result) {
		
		Response<Viagem> response = new Response<>();
		
		Viagem viagemSalva = this.viagemService.salvar(viagemDTO);
		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(viagemDTO.getId()).toUri();
		
		response.setData(viagemSalva);
		
		return ResponseEntity.created(location).body(response);
	}
	
	@GetMapping(path = "tudo")
	public ResponseEntity<List<Viagem>> listar() {
		List<Viagem> viagens = viagemService.listar();
		return ResponseEntity.status(HttpStatus.OK).body(viagens);
	}
	
	@GetMapping(path = "/{id}")
	public ResponseEntity<Viagem> buscar(@PathVariable("id") Long id) {
		
		Viagem viagem = viagemService.buscar(id);
		
//		Response<Viagem> response = new Response<>();
//		response.setData(viagem);
		
		return ResponseEntity.status(HttpStatus.OK).body(viagem);
	}

}

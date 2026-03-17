package com.betacom.jpa.services.implementations;

import java.util.List;

import org.springframework.stereotype.Service;

import com.betacom.jpa.dto.inputs.PersoneReq;
import com.betacom.jpa.dto.outputs.PersoneDTO;
import com.betacom.jpa.exceptions.AcademyException;
import com.betacom.jpa.models.Persone;
import com.betacom.jpa.repositories.IPersoneRepository;
import com.betacom.jpa.services.interfaces.IMessagioServices;
import com.betacom.jpa.services.interfaces.IPersoneServices;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@RequiredArgsConstructor
@Service
public class PersoneImpl implements IPersoneServices {
	private final IPersoneRepository perR;
	private final IMessagioServices msgS;
	@Override
	public void create(PersoneReq req) throws Exception {
		log.debug("create{}",req);
		Persone p = new Persone();
		p.setCognome(req.getCognome());
		p.setColore(req.getColore());
		p.setEmail(req.getEmail());
		p.setNome(req.getNome());
		
		perR.save(p);
	}

	@Override
	public void update(PersoneReq req) throws Exception {
		log.debug("update{}",req);
		Persone p = perR.findById(req.getId())
			.orElseThrow(()->new AcademyException(msgS.get("pers_nt_fnd")));
			if(req.getCognome()!=null)p.setCognome(req.getCognome());
			if(req.getColore()!=null)p.setColore(req.getCognome());
			if(req.getEmail()!=null)p.setEmail(req.getCognome());
			if(req.getNome()!=null)p.setNome(req.getCognome());
			
			perR.save(p);
		
	}

	@Override
	public void delete(Integer id) throws Exception {
		log.debug("delete{}",id);
		Persone p= perR.findById(id)
		.orElseThrow(()->new AcademyException(msgS.get("pers_nt_fnd")));
		perR.delete(p);
		
	}

	@Override
	public List<PersoneDTO> list() {
		log.debug("list{}");
		List<Persone> lP= perR.findAll();
		return lP.stream()
				.map(p->PersoneDTO.builder()
						.id(p.getId())
						.cognome(p.getCognome())
						.colore(p.getColore())
						.email(p.getEmail())
						.nome(p.getNome())
						.build()
						).toList();
						
						
	}

	@Override
	public PersoneDTO getById(Integer id) throws Exception {
		log.debug("getById {}", id);
		Persone p = perR.findById(id)
				.orElseThrow(() -> new AcademyException(msgS.get("pers_ntfnd")));
		
		return PersoneDTO.builder()
				.id(p.getId())
				.cognome(p.getCognome())
				.colore(p.getColore())
				.email(p.getEmail())
				.nome(p.getNome())
				.build();
	
	}

}

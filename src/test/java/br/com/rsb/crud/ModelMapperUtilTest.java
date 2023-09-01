package br.com.rsb.crud;

import org.junit.Test;
import org.modelmapper.TypeToken;

import br.com.rsb.crud.dto.ClienteDTO;
import br.com.rsb.crud.entity.Cliente;
import br.com.rsb.crud.utils.ModelMapperUtil;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;

public class ModelMapperUtilTest {

	ModelMapperUtil mapper;
	
	@Before
	public void setUp(){
		mapper = new ModelMapperUtil();
	}
	
	@Test
	public void testConverterEntidadeParaDTO(){
		
		Cliente origem = new Cliente();
		origem.setNome("Ronaldo");
		
		ClienteDTO dto = (ClienteDTO) mapper.convert(origem, ClienteDTO.class);
		
		Assert.assertEquals(origem.getNome(), dto.getNome());
	}
	
	@Test
	public void testConverterDTOParaEntidade(){
		
		ClienteDTO origem = new ClienteDTO();
		origem.setNome("Ronaldo");
		
		Cliente entidade = (Cliente) mapper.convert(origem, Cliente.class);
		
		Assert.assertEquals(origem.getNome(), entidade.getNome());
	}
	
	@Test
	public void testConverterListaEntidadeParaListaDTO(){
		
		List<Cliente> clientes = new ArrayList<>();
		
		Cliente cliente = new Cliente();
		cliente.setNome("Ronaldo");
		
		clientes.add(cliente);
		
		List<ClienteDTO> clientesDTO = (List<ClienteDTO>) mapper.convert(clientes, new TypeToken<List<ClienteDTO>>(){}.getType());
		
		int size = clientesDTO.size();
		
		Assert.assertTrue(size > 0);
		
		Assert.assertEquals(cliente.getNome(), clientesDTO.get(0).getNome());
		
	}
	
	@Test
	public void testConverterListaDTOParaListaEntidade(){
		
		List<ClienteDTO> dtos = new ArrayList<>();
		
		ClienteDTO dto = new ClienteDTO();
		dto.setNome("Ronaldo");
		
		dtos.add(dto);
		
		List<Cliente> clientes = (List<Cliente>) mapper.convert(dtos, new TypeToken<List<Cliente>>(){}.getType());
		
		int size = clientes.size();
		
		Assert.assertTrue(size > 0);
		
		Assert.assertEquals(dto.getNome(), clientes.get(0).getNome());
		
	}
}

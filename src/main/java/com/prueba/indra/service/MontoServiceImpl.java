package com.prueba.indra.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.prueba.indra.dto.request.MontoDtoRequest;
import com.prueba.indra.dto.response.MontoDtoResponse;
import com.prueba.indra.entity.Moneda;
import com.prueba.indra.entity.Monto;
import com.prueba.indra.entity.TipoCambio;
import com.prueba.indra.repository.MonedaRepository;
import com.prueba.indra.repository.MontoRepository;
import com.prueba.indra.repository.TipoCambioRepository;

@Service
public class MontoServiceImpl implements MontoService {

	@Autowired
	private MontoRepository montoRepository;
	@Autowired
	private TipoCambioRepository tipoCambioRepository;
	@Autowired
	private MonedaRepository monedaRepository;

	@Override
	public MontoDtoResponse guardar(MontoDtoRequest request) {
		MontoDtoResponse response = new MontoDtoResponse();
		List<Moneda> destinos = monedaRepository.buscar(request.getMonedaDestino());
		if (destinos.size() > 0) {
			List<TipoCambio> tipos = tipoCambioRepository.buscar(destinos.get(0).getId());
			if (tipos.size() > 0) {
				Monto monto = new Monto();
				monto.setActual(request.getMonto());
				monto.setConvertido(request.getMonto().multiply(tipos.get(0).getValor()));
				monto.setFecha(new Date());
				monto.setTipoCambio(tipos.get(0));
				List<Moneda> origenes = monedaRepository.buscar(request.getMonedaOrigen());
				monto.setMoneda(origenes.get(0));

				try {
					Monto respuesta = montoRepository.save(monto);
					response.setMonto(respuesta.getActual());
					response.setMontoConTipoDeCambio(respuesta.getConvertido());
					response.setMonedaOrigen(respuesta.getMoneda().getDescripcion());
					response.setMonedaDestino(respuesta.getTipoCambio().getMoneda().getDescripcion());
					response.setTipoDeCambio(respuesta.getTipoCambio().getValor());
					
					response.setEstado("OK");
					response.setDescripcion("Trx del proceso realizado: "+respuesta.getId());
				} catch (Exception e) {
					response.setEstado(e.getMessage());
					response.setDescripcion(e.getStackTrace().toString());
				}
			}
		}

		return response;
	}

}

package br.nom.consani.gerenciadorativos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import br.nom.consani.gerenciadorativos.model.SensorData;
import br.nom.consani.gerenciadorativos.repositorio.Metricas;

@Controller
@RequestMapping("/api/v1")
public class MetricaController {

	@Autowired
	private Metricas metricas;

	@RequestMapping(value = "/sensores/metricas", method = RequestMethod.POST, produces = "application/json", consumes = "application/json")
	@ResponseBody
	public SensorData receberMetricaSensor(@RequestBody SensorData sensorData) {
		System.out.println(sensorData);

		metricas.save(sensorData);

		return sensorData;
	}

	@RequestMapping(value = "/sensores/metricas", method = RequestMethod.GET, produces = "application/json")
	@ResponseBody
	public List<SensorData> list() {

		List<SensorData> listaMetricas = metricas.findAll();
		
		return listaMetricas;
	}

}

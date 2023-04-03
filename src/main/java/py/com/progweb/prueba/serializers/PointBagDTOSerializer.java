package py.com.progweb.prueba.serializers;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import py.com.progweb.prueba.dto.PointBagDTO;

import java.io.IOException;

public class PointBagDTOSerializer extends StdSerializer<PointBagDTO> {

    public PointBagDTOSerializer() {
        this(null);
    }

    public PointBagDTOSerializer(Class<PointBagDTO> t) {
        super(t);
    }

    @Override
    public void serialize(PointBagDTO value, JsonGenerator gen, SerializerProvider provider) throws IOException {
        gen.writeStartObject();
        gen.writeNumberField("idBolsa", value.getIdBolsa());
        gen.writeStringField("nombre", value.getNombre());
        gen.writeStringField("apellido", value.getApellido());
        gen.writeStringField("fechaAsignacion", value.getFechaAsignacion().toString());
        gen.writeStringField("fechaCaducidad", value.getFechaCaducidad().toString());
        gen.writeNumberField("puntajeAsignado", value.getPuntajeAsignado());
        gen.writeNumberField("saldo", value.getSaldo());
        gen.writeNumberField("monto", value.getMonto());
        gen.writeStringField("estado", value.getEstado());
        gen.writeEndObject();
    }
}

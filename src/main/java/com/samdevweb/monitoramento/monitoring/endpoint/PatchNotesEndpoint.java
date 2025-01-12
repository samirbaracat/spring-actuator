package com.samdevweb.monitoramento.monitoring.endpoint;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.boot.actuate.endpoint.annotation.DeleteOperation;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import jakarta.annotation.PostConstruct;

@Component
@Endpoint(id = "patch-notes")
public class PatchNotesEndpoint {

    Map<String, List<String>> patchNotes = new HashMap<>();

    @PostConstruct
    public void initNotes() {
        List<String> notes = new ArrayList<>(Arrays.asList(
                "Adicionada verificação de integridade para conexão com a internet.",
                "Adicionadas informações personalizadas sobre detalhes do usuário.",
                "Endpoint HttpTrace lançado."));
        this.patchNotes.put("v1", notes);
    }

    @ReadOperation
    public Map<String, List<String>> getPatchNotes() {
        return this.patchNotes;
    }

    @ReadOperation
    public List<String> getByVersion(@Selector String version) {
        return this.patchNotes.get(version);
    }

    @WriteOperation
    public void addPatchNote(@Selector String version, @Selector String notes) {
        if (ObjectUtils.isEmpty(this.patchNotes.get(version))) {
            this.patchNotes.put(version, Arrays.stream(notes.split(",")).collect(Collectors.toList()));
        } else {
            this.patchNotes.get(version).addAll(Arrays.stream(notes.split(",")).collect(Collectors.toList()));
        }
    }

    @DeleteOperation
    public void deleteNotes(@Selector String version) {
        this.patchNotes.remove(version);
    }

    
}

# Prova1Backend
Avaliação I  Programação Backend


## 1-) Descreva aqui o comando para criação do banco (utilizado no mongosh ou compass), que deverá ser chamado tech4music

use Tech4music

## 2-) Descreva o comando para criar a coleção musicas e já inserir 3 músicas abaixo:

    db.createCollection("Musicas")

    db.Musicas.insert([
    {
    "titulo": "Forever",
    "artista": "Kiss",
    "album": "Hot in the Shade",
    "genero": "Rock",
    "anoLancamento": 1989,
    "compositor": "Paul Stanley"
    },

    {"titulo": "Algo parecido",
    "artista": "Skank",
    "album": "Os três primeiros",
    "genero": "Pop",
    "anoLancamento": 2018,
    "compositor": "Samuel Rosa"
    },

    {"titulo": "O que me importa",
    "artista": "Marisa Monte",
    "album": "Memórias, crônicas e declarações de amor",
    "genero": "MPB",
    "anoLancamento": 2000,
    "compositor": "Jose de Ribamar Cury"},
    ])

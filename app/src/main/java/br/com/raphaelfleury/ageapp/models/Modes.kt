package br.com.raphaelfleury.ageapp.models

data class Modes(
    val qm_2v2: Qm2v2,
    val qm_3v3: Qm3v3,
    val qm_4v4: Qm4v4,
    val rm_1v1: Rm1v1,
    val rm_2v2_elo: Rm2v2Elo,
    val rm_3v3_elo: Rm3v3Elo,
    val rm_4v4_elo: Rm4v4Elo,
    val rm_solo: RmSolo,
    val rm_team: RmTeam
)
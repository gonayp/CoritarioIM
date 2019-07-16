package inis.coritario;

import java.util.Random;

/**
 * Created by gonay.pico on 06/10/2015.
 */
public class Auxiliar {


    public static int CargarCoros(int coro, boolean acordes) {

        int i =0;
        int Coro = 0;
        //NumCoros= 70;
        if (!acordes) coro +=200;

        switch (coro) {
            case 1:
                Coro = R.layout.id1_abre_mis_ojos_;
                break;
            case 2:
                Coro = R.layout.id2agnus_dei_;
                break;
            case 3:
                Coro = R.layout.id3alabar_;
                break;
            case 4:
                Coro = R.layout.id4al_encuentro_de_jess_;
                break;
            case 5:
                Coro = R.layout.id5alma_misionera_;
                break;
            case 6:
                Coro = R.layout.id6alto_escchame_;
                break;
            case 7:
                Coro = R.layout.id7alzar_mis_ojos_;
                break;
            case 8:
                Coro = R.layout.id8amor_amor_;
                break;
            case 9:
                Coro = R.layout.id9arco_iris_;
                break;
            case 10:
                Coro = R.layout.id10atardece_;
                break;
            case 11:
                Coro = R.layout.id11avancemos_;
                break;
            case 12:
                Coro = R.layout.id12blanqueados_;
                break;
            case 13:
                Coro = R.layout.id13brilla_jess_;
                break;
            case 14:
                Coro = R.layout.id14brillar_por_ti_;
                break;
            case 15:
                Coro = R.layout.id15buscad_primero_;
                break;
            case 16:
                Coro = R.layout.id16cada_da_de_maana_;
                break;
            case 17:
                Coro = R.layout.id17cantad_a_dios_;
                break;
            case 18:
                Coro = R.layout.id18cantar_de_tu_amor_;
                break;
            case 19:
                Coro = R.layout.id19canto_de_alegra_;
                break;
            case 20:
                Coro = R.layout.id20cerca_de_jess_;
                break;
            case 21:
                Coro = R.layout.id21como_el_ciervo_;
                break;
            case 22:
                Coro = R.layout.id22cmo_no_cantar_;
                break;
            case 23:
                Coro = R.layout.id23cristo_joven_;
                break;
            case 24:
                Coro = R.layout.id24cun_grande_eres_dios__;
                break;
            case 25:
                Coro = R.layout.id25cuando_cristo_vino_a_mi_corazn_;
                break;
            case 26:
                Coro = R.layout.id26cuando_el_pueblo_de_dios_ora_;
                break;
            case 27:
                Coro = R.layout.id27cuando_miro_los_claros_cielos_;
                break;
            case 28:
                Coro = R.layout.id28da_una_sonrisa_;
                break;
            case 29:
                Coro = R.layout.id29dad_gloria_al_seor_;
                break;
            case 30:
                Coro = R.layout.id30dad_gracias_;
                break;
            case 31:
                Coro = R.layout.id31dame_un_nuevo_corazn_;
                break;
            case 32:
                Coro = R.layout.id32descansar_;
                break;
            case 33:
                Coro = R.layout.id33despus_del_ro_;
                break;
            case 34:
                Coro = R.layout.id34digno_eres_;
                break;
            case 35:
                Coro = R.layout.id35dios_alzamos_hoy_tu_nombre_;
                break;
            case 36:
                Coro = R.layout.id36dios_bueno_es_;
                break;
            case 37:
                Coro = R.layout.id37dios_del_cielo_;
                break;
            case 38:
                Coro = R.layout.id38dios_es_nuestro_amparo_y_fortaleza_;
                break;
            case 39:
                Coro = R.layout.id39dios_est_aqu_;
                break;
            case 40:
                Coro = R.layout.id40dios_que_tu_luz_;
                break;
            case 41:
                Coro = R.layout.id41el_corazn_de_la_adoracin_;
                break;
            case 42:
                Coro = R.layout.id42el_mejor_lugar_del_mundo_;
                break;
            case 43:
                Coro = R.layout.id43enciende_una_luz_;
                break;
            case 44:
                Coro = R.layout.id44eres_mi_respirar_;
                break;
            case 45:
                Coro = R.layout.id45eres_mi_todo_;
                break;
            case 46:
                Coro = R.layout.id46eres_t_;
                break;
            case 47:
                Coro = R.layout.id47es_exaltado_;
                break;
            case 48:
                Coro = R.layout.id48s_o_meu_refgio_;
                break;
            case 49:
                Coro = R.layout.id49espritu_santo_;
                break;
            case 50:
                Coro = R.layout.id50este_es_mi_deseo_;
                break;
            case 51:
                Coro = R.layout.id51estoy_en_paz_;
                break;
            case 52:
                Coro = R.layout.id52fiel_en_toda_prueba_;
                break;
            case 53:
                Coro = R.layout.id53fija_tus_ojos_;
                break;
            case 54:
                Coro = R.layout.id54grande_es_jehov_;
                break;
            case 55:
                Coro = R.layout.id55hablar_con_dios_;
                break;
            case 56:
                Coro = R.layout.id56he_decido_seguir_a_cristo_;
                break;
            case 57:
                Coro = R.layout.id57hosanna_;
                break;
            case 58:
                Coro = R.layout.id58hoy_aqu_;
                break;
            case 59:
                Coro = R.layout.id59jess_mi_gua_es_;
                break;
            case 60:
                Coro = R.layout.id60jess_te_ama_;
                break;
            case 61:
                Coro = R.layout.id61la_alegria_;
                break;
            case 62:
                Coro = R.layout.id62la_naturaleza_;
                break;
            case 63:
                Coro = R.layout.id63la_maana_gloriosa_;
                break;
            case 64:
                Coro = R.layout.id64la_sangre_de_cristo_jess_;
                break;
            case 65:
                Coro = R.layout.id65lado_a_lado_;
                break;
            case 66:
                Coro = R.layout.id66majestuoso_dios_;
                break;
            case 67:
                Coro = R.layout.id67maravilloso_dios_;
                break;
            case 68:
                Coro = R.layout.id68mensajero_;
                break;
            case 69:
                Coro = R.layout.id69mi_cristo_me_salva_;
                break;
            case 70:
                Coro = R.layout.id70mi_dios_supremo_rey_;
                break;
            case 71:
                Coro = R.layout.id71mi_todo_;
                break;
            case 72:
                Coro = R.layout.id72mirad_cul_amor_;
                break;
            case 73:
                Coro = R.layout.id73necesario__;
                break;
            case 74:
                Coro = R.layout.id74no_me_importa_de_;
                break;
            case 75:
                Coro = R.layout.id75no_me_olvide_de_ti__;
                break;
            case 76:
                Coro = R.layout.id76nunca_ests_;
                break;
            case 77:
                Coro = R.layout.id77oba_oba_;
                break;
            case 78:
                Coro = R.layout.id78oh_amor_de_dios__;
                break;
            case 79:
                Coro = R.layout.id79padre_de_amor__;
                break;
            case 80:
                Coro = R.layout.id80padre_yo_te_adoro_;
                break;
            case 81:
                Coro = R.layout.id81paso_a_paso_;
                break;
            case 82:
                Coro = R.layout.id82paz_en_la_tormenta_;
                break;
            case 83:
                Coro = R.layout.id83permanece_en_m_;
                break;
            case 84:
                Coro = R.layout.id84pescador_;
                break;
            case 85:
                Coro = R.layout.id85porencima_de_todo_;
                break;
            case 86:
                Coro = R.layout.id86por_tu_gracia_y_amor_;
                break;
            case 87:
                Coro = R.layout.id87prncipede_paz_;
                break;
            case 88:
                Coro = R.layout.id88promesa_;
                break;
            case 89:
                Coro = R.layout.id89queremos_ver_a_cristo_regresar_;
                break;
            case 90:
                Coro = R.layout.id90queremosver_a_cristo_regresar__;
                break;
            case 91:
                Coro = R.layout.id91quiero_cantar_;
                break;
            case 92:
                Coro = R.layout.id92rendid_a_yahv_;
                break;
            case 93:
                Coro = R.layout.id93renuvame_;
                break;
            case 94:
                Coro = R.layout.id94salmo__;
                break;
            case 95:
                Coro = R.layout.id95santo_es_el_seor_;
                break;
            case 96:
                Coro = R.layout.id96santo_espritu_;
                break;
            case 97:
                Coro = R.layout.id97sentado_estaba_en_mi_barca_;
                break;
            case 98:
                Coro = R.layout.id98seor_aviva_tu_obra_en_m_;
                break;
            case 99:
                Coro = R.layout.id99si_comenzamos_a_orar_;
                break;
            case 100:
                Coro = R.layout.id100;
                break;
            case 101:
                Coro = R.layout.id101tu_amor_por_m_;
                break;
            case 102:
                Coro = R.layout.id102tueres_dios_;
                break;
            case 103:
                Coro = R.layout.id103tu_poder_;
                break;
            case 104:
                Coro = R.layout.id104tuyo_soy_;
                break;
            case 105:
                Coro = R.layout.id105vamos_adorar_al_seor_;
                break;
            case 106:
                Coro = R.layout.id106vaso_de_honra_;
                break;
            case 107:
                Coro = R.layout.id107ven_a_la_cruz_;
                break;
            case 108:
                Coro = R.layout.id108ven_es_tiempo_de_adorarle_;
                break;
            case 109:
                Coro = R.layout.id109vengoa_adorarte_;
                break;
            case 110:
                Coro = R.layout.id110voy_caminando_;
                break;
            case 111:
                Coro = R.layout.id111yo_tengo_esperanza_;
                break;

            case 201:
                Coro = R.layout.is1_abre_mis_ojos_;
                break;
            case 202:
                Coro = R.layout.is2agnus_dei_;
                break;
            case 203:
                Coro = R.layout.is3alabar_;
                break;
            case 204:
                Coro = R.layout.is4al_encuentro_de_jess_;
                break;
            case 205:
                Coro = R.layout.is5alma_misionera_;
                break;
            case 206:
                Coro = R.layout.is6alto_escchame_;
                break;
            case 207:
                Coro = R.layout.is7alzar_mis_ojos_;
                break;
            case 208:
                Coro = R.layout.is8amor_amor_;
                break;
            case 209:
                Coro = R.layout.is9arco_iris_;
                break;
            case 210:
                Coro = R.layout.is10atardece_;
                break;
            case 211:
                Coro = R.layout.is11avancemos_;
                break;
            case 212:
                Coro = R.layout.is12blanqueados_;
                break;
            case 213:
                Coro = R.layout.is13brilla_jess_;
                break;
            case 214:
                Coro = R.layout.is14brillar_por_ti_;
                break;
            case 215:
                Coro = R.layout.is15buscad_primero_;
                break;
            case 216:
                Coro = R.layout.is16cada_da_de_maana_;
                break;
            case 217:
                Coro = R.layout.is17cantad_a_dios_;
                break;
            case 218:
                Coro = R.layout.is18cantar_de_tu_amor_;
                break;
            case 219:
                Coro = R.layout.is19canto_de_alegra_;
                break;
            case 220:
                Coro = R.layout.is20cerca_de_jess_;
                break;
            case 221:
                Coro = R.layout.is21como_el_ciervo_;
                break;
            case 222:
                Coro = R.layout.is22cmo_no_cantar_;
                break;
            case 223:
                Coro = R.layout.is23cristo_joven_;
                break;
            case 224:
                Coro = R.layout.is24cun_grande_eres_dios__;
                break;
            case 225:
                Coro = R.layout.is25cuando_cristo_vino_a_mi_corazn_;
                break;
            case 226:
                Coro = R.layout.is26cuando_el_pueblo_de_dios_ora_;
                break;
            case 227:
                Coro = R.layout.is27cuando_miro_los_claros_cielos_;
                break;
            case 228:
                Coro = R.layout.is28da_una_sonrisa_;
                break;
            case 229:
                Coro = R.layout.is29dad_gloria_al_seor_;
                break;
            case 230:
                Coro = R.layout.is30dad_gracias_;
                break;
            case 231:
                Coro = R.layout.is31dame_un_nuevo_corazn_;
                break;
            case 232:
                Coro = R.layout.is32descansar_;
                break;
            case 233:
                Coro = R.layout.is33despus_del_ro_;
                break;
            case 234:
                Coro = R.layout.is34digno_eres_;
                break;
            case 235:
                Coro = R.layout.is35dios_alzamos_hoy_tu_nombre_;
                break;
            case 236:
                Coro = R.layout.is36dios_bueno_es_;
                break;
            case 237:
                Coro = R.layout.is37dios_del_cielo_;
                break;
            case 238:
                Coro = R.layout.is38dios_es_nuestro_amparo_y_fortaleza_;
                break;
            case 239:
                Coro = R.layout.is39dios_est_aqu_;
                break;
            case 240:
                Coro = R.layout.is40dios_que_tu_luz_;
                break;
            case 241:
                Coro = R.layout.is41el_corazn_de_la_adoracin_;
                break;
            case 242:
                Coro = R.layout.is42el_mejor_lugar_del_mundo_;
                break;
            case 243:
                Coro = R.layout.is43enciende_una_luz_;
                break;
            case 244:
                Coro = R.layout.is44eres_mi_respirar_;
                break;
            case 245:
                Coro = R.layout.is45eres_mi_todo_;
                break;
            case 246:
                Coro = R.layout.is46eres_t_;
                break;
            case 247:
                Coro = R.layout.is47es_exaltado_;
                break;
            case 248:
                Coro = R.layout.is48s_o_meu_refgio_;
                break;
            case 249:
                Coro = R.layout.is49espritu_santo_;
                break;
            case 250:
                Coro = R.layout.is50este_es_mi_deseo_;
                break;
            case 251:
                Coro = R.layout.is51estoy_en_paz_;
                break;
            case 252:
                Coro = R.layout.is52fiel_en_toda_prueba_;
                break;
            case 253:
                Coro = R.layout.is53fija_tus_ojos_;
                break;
            case 254:
                Coro = R.layout.is54grande_es_jehov_;
                break;
            case 255:
                Coro = R.layout.is55hablar_con_dios_;
                break;
            case 256:
                Coro = R.layout.is56he_decido_seguir_a_cristo_;
                break;
            case 257:
                Coro = R.layout.is57hosanna_;
                break;
            case 258:
                Coro = R.layout.is58hoy_aqu_;
                break;
            case 259:
                Coro = R.layout.is59jess_mi_gua_es_;
                break;
            case 260:
                Coro = R.layout.is60jess_te_ama_;
                break;
            case 261:
                Coro = R.layout.is61la_alegria_;
                break;
            case 262:
                Coro = R.layout.is62la_naturaleza_;
                break;
            case 263:
                Coro = R.layout.is63la_maana_gloriosa_;
                break;
            case 264:
                Coro = R.layout.is64la_sangre_de_cristo_jess_;
                break;
            case 265:
                Coro = R.layout.is65lado_a_lado_;
                break;
            case 266:
                Coro = R.layout.is66majestuoso_dios_;
                break;
            case 267:
                Coro = R.layout.is67maravilloso_dios_;
                break;
            case 268:
                Coro = R.layout.is68mensajero_;
                break;
            case 269:
                Coro = R.layout.is69mi_cristo_me_salva_;
                break;
            case 270:
                Coro = R.layout.is70mi_dios_supremo_rey_;
                break;
            case 271:
                Coro = R.layout.is71mi_todo_;
                break;
            case 272:
                Coro = R.layout.is72mirad_cul_amor_;
                break;
            case 273:
                Coro = R.layout.is73necesario__;
                break;
            case 274:
                Coro = R.layout.is74no_me_importa_de_dnde_t_vengas__;
                break;
            case 275:
                Coro = R.layout.is75no_me_olvide_de_ti__;
                break;
            case 276:
                Coro = R.layout.is76nunca_ests_desanimado_;
                break;
            case 277:
                Coro = R.layout.is77oba_oba_;
                break;
            case 278:
                Coro = R.layout.is78oh_amor_de_dios__;
                break;
            case 279:
                Coro = R.layout.is79padre_de_amor__;
                break;
            case 280:
                Coro = R.layout.is80padre_yo_te_adoro_;
                break;
            case 281:
                Coro = R.layout.is81paso_a_paso_;
                break;
            case 282:
                Coro = R.layout.is82paz_en_la_tormenta_;
                break;
            case 283:
                Coro = R.layout.is83permanece_en_m_;
                break;
            case 284:
                Coro = R.layout.is84pescador_;
                break;
            case 285:
                Coro = R.layout.is85porencima_de_todo_;
                break;
            case 286:
                Coro = R.layout.is86por_tu_gracia_y_amor_;
                break;
            case 287:
                Coro = R.layout.is87prncipede_paz_;
                break;
            case 288:
                Coro = R.layout.is88promesa_;
                break;
            case 289:
                Coro = R.layout.is89queremos_ver_a_cristo_regresar_;
                break;
            case 290:
                Coro = R.layout.is90quiero_cantar_;
                break;
            case 291:
                Coro = R.layout.is91rendid_a_yahv_;
                break;
            case 292:
                Coro = R.layout.is92renuvame_;
                break;
            case 293:
                Coro = R.layout.is93salmo__;
                break;
            case 294:
                Coro = R.layout.is94santo_es_el_seor_;
                break;
            case 295:
                Coro = R.layout.is95santo_espritu_;
                break;
            case 296:
                Coro = R.layout.is96sentado_estaba_en_mi_barca_;
                break;
            case 297:
                Coro = R.layout.is97seor_aviva_tu_obra_en_m_;
                break;
            case 298:
                Coro = R.layout.is98si_comenzamos_a_orar_;
                break;
            case 299:
                Coro = R.layout.is99;
                break;
            case 300:
                Coro = R.layout.is100tu_amor_por_m_;
                break;
            case 301:
                Coro = R.layout.is101tueres_dios_;
                break;
            case 302:
                Coro = R.layout.is102tu_poder_;
                break;
            case 303:
                Coro = R.layout.is103tuyo_soy_;
                break;
            case 304:
                Coro = R.layout.is104vamos_adorar_al_seor_;
                break;
            case 305:
                Coro = R.layout.is105vaso_de_honra_;
                break;
            case 306:
                Coro = R.layout.is106ven_a_la_cruz_;
                break;
            case 307:
                Coro = R.layout.is107ven_es_tiempo_de_adorarle_;
                break;
            case 308:
                Coro = R.layout.is108vengoa_adorarte_;
                break;
            case 309:
                Coro = R.layout.is109voy_caminando_;
                break;
            case 310:
                Coro = R.layout.is110yo_tengo_esperanza_;
                break;
            case 311:
                Coro = R.layout.is111yo_voy_;
                break;
        }
        

    return Coro;


    }



    public static int CargarCoroAcordes(int coro){

        int Coro = 0;

        switch (coro) {
        case 1:
        Coro = R.drawable.ic01;
        break;
        case 2:
        Coro = R.drawable.ic02;
        break;

        case 3:
        Coro = R.drawable.ic03;
        break;

        case 4:
        Coro = R.drawable.ic04;
        break;
        case 5:
        Coro = R.drawable.ic05;
        break;
        case 6:
        Coro = R.drawable.ic06;
        break;
        case 7:
        Coro = R.drawable.ic07;
        break;
        case 8:
        Coro = R.drawable.ic08;
        break;
        case 9:
        Coro = R.drawable.ic09;
        break;
        case 10:
        Coro = R.drawable.ic10;
        break;
        case 11:
        Coro = R.drawable.ic11;
        break;
        case 12:
        Coro = R.drawable.ic12;
        break;
        case 13:
        Coro = R.drawable.ic13;
        break;
        case 14:
        Coro = R.drawable.ic14;
        break;
        case 15:
        Coro = R.drawable.ic15;
        break;
        case 16:
        Coro = R.drawable.ic16;
        break;
        case 17:
        Coro = R.drawable.ic17;
        break;
        case 18:
        Coro = R.drawable.ic18;
        break;
        case 19:
        Coro = R.drawable.ic19;
        break;
        case 20:
        Coro = R.drawable.ic20;
        break;
        case 21:
        Coro = R.drawable.ic21;
        break;
        case 22:
        Coro = R.drawable.ic22;
        break;
        case 23:
        Coro = R.drawable.ic23;
        break;
        case 24:
        Coro = R.drawable.ic24;
        break;
        case 25:
        Coro = R.drawable.ic25;
        break;
        case 26:
        Coro = R.drawable.ic26;
        break;
        case 27:
        Coro = R.drawable.ic27;
        break;
        case 28:
        Coro = R.drawable.ic28;
        break;
        case 29:
        Coro = R.drawable.ic29;
        break;
        case 30:
        Coro = R.drawable.ic30;
        break;
        case 31:
        Coro = R.drawable.ic31;
        break;
        case 32:
        Coro = R.drawable.ic32;
        break;
        case 33:
        Coro = R.drawable.ic33;
        break;
        case 34:
        Coro = R.drawable.ic34;
        case 35:
        Coro = R.drawable.ic35;
        break;
        case 36:
        Coro = R.drawable.ic36;
        break;
        case 37:
        Coro = R.drawable.ic37;
        break;
        case 38:
        Coro = R.drawable.ic38;
        break;
        case 39:
        Coro = R.drawable.ic39;
        break;
        case 40:
        Coro = R.drawable.ic40;
        break;
        case 41:
        Coro = R.drawable.ic41;
        break;
        case 42:
        Coro = R.drawable.ic42;
        break;
        case 43:
        Coro = R.drawable.ic43;
        break;
        case 44:
        Coro = R.drawable.ic44;
        break;
        case 45:
        Coro = R.drawable.ic45;
        break;
        case 46:
        Coro = R.drawable.ic46;
        break;
        case 47:
        Coro = R.drawable.ic47;
        break;
        case 48:
        Coro = R.drawable.ic48;
        break;
        case 49:
        Coro = R.drawable.ic49;
        break;
        case 50:
        Coro = R.drawable.ic50;
        break;
        case 51:
        Coro = R.drawable.ic51;
        break;
        case 52:
        Coro = R.drawable.ic52;
        break;
        case 53:
        Coro = R.drawable.ic53;
        break;
        case 54:
        Coro = R.drawable.ic54;
        break;
        case 55:
        Coro = R.drawable.ic55;
        break;
        case 56:
        Coro = R.drawable.ic56;
        break;
        case 57:
        Coro = R.drawable.ic57;
        break;
        case 58:
        Coro = R.drawable.ic58;
        break;
        case 59:
        Coro = R.drawable.ic59;
        break;
        case 60:
        Coro = R.drawable.ic60;
        break;
        case 61:
        Coro = R.drawable.ic61;
        break;
        case 62:
        Coro = R.drawable.ic62;
        break;
        case 63:
        Coro = R.drawable.ic63;
        break;
        case 64:
        Coro = R.drawable.ic64;
        break;
        case 65:
        Coro = R.drawable.ic65;
        break;
        case 66:
        Coro = R.drawable.ic66;
        break;
        case 67:
        Coro = R.drawable.ic67;
        break;
        case 68:
        Coro = R.drawable.ic68;
        break;
        case 69:
        Coro = R.drawable.ic69;
        break;
        case 70:
        Coro = R.drawable.ic70;
        break;
        case 71:
        Coro = R.drawable.ic71;
        break;
        case 72:
        Coro = R.drawable.ic72;
        break;
        case 73:
        Coro = R.drawable.ic73;
        break;
        case 74:
        Coro = R.drawable.ic74;
        break;
        case 75:
        Coro = R.drawable.ic75;
        break;
        case 76:
        Coro = R.drawable.ic76;
        break;
        case 77:
        Coro = R.drawable.ic77;
        break;
        case 78:
        Coro = R.drawable.ic78;
        break;
        case 79:
        Coro = R.drawable.ic79;
        break;
        case 80:
        Coro = R.drawable.ic80;
        break;
        case 81:
        Coro = R.drawable.ic81;
        break;
        case 82:
        Coro = R.drawable.ic82;
        break;
        case 83:
        Coro = R.drawable.ic83;
        break;
        case 84:
        Coro = R.drawable.ic84;
        break;
        case 85:
        Coro = R.drawable.ic85;
        break;
        case 86:
        Coro = R.drawable.ic86;
        break;
        case 87:
        Coro = R.drawable.ic87;
        break;
        case 88:
        Coro = R.drawable.ic88;
        break;
        case 89:
        Coro = R.drawable.ic89;
        break;
        case 90:
        Coro = R.drawable.ic90;
        break;
        case 91:
        Coro = R.drawable.ic91;
        break;
        case 92:
        Coro = R.drawable.ic92;
        break;
        case 93:
        Coro = R.drawable.ic93;
        break;
        case 94:
        Coro = R.drawable.ic94;
        break;
        case 95:
        Coro = R.drawable.ic95;
        break;
        case 96:
        Coro = R.drawable.ic96;
        break;
        case 97:
        Coro = R.drawable.ic97;
        break;
        case 98:
        Coro = R.drawable.ic98;
        break;
        case 99:
        Coro = R.drawable.ic99;
        break;
        case 100:
        Coro = R.drawable.ic100;
        break;
        case 101:
        Coro = R.drawable.ic101;
        break;
        case 102:
        Coro = R.drawable.ic102;
        break;
        case 103:
        Coro = R.drawable.ic103;
        break;
        case 104:
        Coro = R.drawable.ic104;
        break;
        case 105:
        Coro = R.drawable.ic105;
        break;
        case 106:
        Coro = R.drawable.ic106;
        break;
        case 107:
        Coro = R.drawable.ic107;
        break;
        case 108:
        Coro = R.drawable.ic108;
        break;
        case 109:
        Coro = R.drawable.ic109;
        break;
        case 110:
        Coro = R.drawable.ic110;
        break;
        case 111:
        Coro = R.drawable.ic111;
        break;

        }


        return Coro;


    }


    public static  int CargarFotos(int coro) {

        int Foto;
        int min = 0;
        int max = 18;

        Random r = new Random();
        //int i = r.nextInt(max - min + 1) + min;
        int i = coro%30;

        Foto = 0;

        switch (i) {
            case 0:
                Foto = R.drawable.id1;
                break;
            case 1:
                Foto = R.drawable.id2;
                break;
            case 2:
                Foto = R.drawable.id3;
                break;
            case 3:
                Foto = R.drawable.id4;
                break;
            case 4:
                Foto = R.drawable.id5;
                break;
            case 5:
                Foto = R.drawable.id6;
                break;
            case 6:
                Foto = R.drawable.id7;
                break;
            case 7:
                Foto = R.drawable.id8;
                break;
            case 8:
                Foto = R.drawable.id9;
                break;
            case 9:
                Foto = R.drawable.id10;
                break;
            case 10:
                Foto = R.drawable.id11;
                break;
            case 11:
                Foto = R.drawable.id12;
                break;
            case 12:
                Foto = R.drawable.id13;
                break;
            case 13:
                Foto = R.drawable.id14;
                break;
            case 14:
                Foto = R.drawable.id15;
                break;
            case 15:
                Foto = R.drawable.id16;
                break;
            case 16:
                Foto = R.drawable.id17;
                break;
            case 17:
                Foto = R.drawable.id18;
                break;
            case 18:
                Foto = R.drawable.id19;
                break;
            case 19:
                Foto = R.drawable.id20;
                break;
            case 20:
                Foto = R.drawable.id21;
                break;
            case 21:
                Foto = R.drawable.id22;
                break;
            case 22:
                Foto = R.drawable.id23;
                break;
            case 23:
                Foto = R.drawable.id24;
                break;
            case 24:
                Foto = R.drawable.id25;
                break;
            case 25:
                Foto = R.drawable.id26;
                break;
            case 26:
                Foto = R.drawable.id27;
                break;
            case 27:
                Foto = R.drawable.id28;
                break;
            case 28:
                Foto = R.drawable.id29;
                break;
            case 29:
                Foto = R.drawable.id30;
                break;
        }
        return Foto;
    }
}

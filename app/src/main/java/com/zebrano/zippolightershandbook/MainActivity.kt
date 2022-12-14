package com.zebrano.zippolightershandbook

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import com.zebrano.zippolightershandbook.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var bindingObj : ActivityMainBinding
    private val adapter = LightersAdapter()
    private var index = 0
    private val imagesList = listOf(
        R.drawable.zippo_abstract_faces_design,
        R.drawable.zippo_boxing_design,
        R.drawable.zippo_abstract_psychedelia,
        R.drawable.zippo_artificial_intelligence,
        R.drawable.zippo_butterfly_skull_design,
        R.drawable.zippo_celebrating_movies,
        R.drawable.zippo_cloudy_sky,
        R.drawable.zippo_currency_design,
        R.drawable.zippo_dragon_cat_design,
        R.drawable.zippo_fishy_design,
        R.drawable.zippo_fusion_space,
        R.drawable.zippo_gaming_cheat_code,
        R.drawable.zippo_glowing_zodiac_design,
        R.drawable.zippo_graffiti_peace_design,
        R.drawable.zippo_greek_god_clash_design,
        R.drawable.zippo_greetings_from_zippo,
        R.drawable.zippo_halloween_design,
        R.drawable.zippo_kimono_design,
        R.drawable.zippo_kimono_pattern_design,
        R.drawable.zippo_lady_skull_design,
        R.drawable.zippo_leopard_print,
        R.drawable.zippo_lion_design,
        R.drawable.zippo_literary_anatomy,
        R.drawable.zippo_lizard_fusion,
        R.drawable.zippo_lovers_design,
        R.drawable.zippo_moonlight_crow_design,
        R.drawable.zippo_occult_design,
        R.drawable.zippo_plague_of_disinformation,
        R.drawable.zippo_psychedelic_imagery_design,
        R.drawable.zippo_ramen_dragon_design,
        R.drawable.zippo_red_box_top_design,
        R.drawable.zippo_retro_futuristic,
        R.drawable.zippo_rib_cage_design,
        R.drawable.zippo_robot_design,
        R.drawable.zippo_skulls_design,
        R.drawable.zippo_snake_bouquet_design,
        R.drawable.zippo_snake_design,
        R.drawable.zippo_snake_skin_design,
        R.drawable.zippo_solar_system_design,
        R.drawable.zippo_suitcase_design,
        R.drawable.zippo_sunbeam_pendant,
        R.drawable.zippo_sunflower_design,
        R.drawable.zippo_sushi_design,
        R.drawable.zippo_taped_flint_dispenser,
        R.drawable.zippo_tiger_design,
        R.drawable.zippo_topo_map_design,
        R.drawable.zippo_whale_design,
        R.drawable.zippo_white_rabbit_design)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindingObj = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindingObj.root)

        init()
    }

    private fun init(){
        // or func() = with(bindingObj)
        bindingObj.apply {
            rcView.layoutManager = GridLayoutManager(this@MainActivity, 2)
            rcView.adapter = adapter
            buttonAddCard.setOnClickListener {
                val lighter = Lighter(imagesList[index], "Zippo $index", "Cool Zippo lighter!")
                adapter.addZippo(lighter)
                index++
                if(index>=imagesList.count())
                    index = 0
            }

        }
    }
}
package com.example.pathfindergametool

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.pathfindergametool.databinding.SpellListTemplateBinding

data class Spell(var Name:String, var Description:String, var Source:String, var Distance:String, var Area:String, var TimeCast:String, var Components:String,
                 var Target:String, var Duration:String, var SaveRoll:String, var SpellResist:String, var School:String, var Nation:String, var Translator:String,
                 var Effect:String, var OriginaLink:String, var Level:Level)


data class Level(var Adept:Int, var Alchemist:Int, var Antipaladin: Int, var Arcanist: Int, var Bard: Int, var Witch: Int, var Wizard: Int, var Mesmerist: Int, var Druid: Int,
            var Cleric: Int, var Warpriest: Int, var Inquisitor: Int, var Magus: Int, var Bloodrager: Int, var Occultist: Int, var Omdura: Int, var Oracle: Int, var Hunter: Int,
            var Paladin: Int, var Summoner: Int, var Investigator: Int, var Ranger: Int, var Spiritualist: Int, var Sorcerer: Int, var Shaman: Int, var Psychic: Int)

class SpellAdapter(private val context: Context, private val spellList: MutableList<Spell>):
    RecyclerView.Adapter<SpellAdapter.SpellViewHolder>() {

    class SpellViewHolder(spellLayoutBinding: SpellListTemplateBinding):RecyclerView.ViewHolder(spellLayoutBinding.root){
        private val binding = spellLayoutBinding

        fun bind(spellItem: Spell){
            binding.nameSpellTemplate.text = spellItem.Name
            binding.schoolSpellTemplate.text = spellItem.School
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SpellViewHolder {
        var binding = SpellListTemplateBinding.inflate(LayoutInflater.from(context),parent,false)
        return SpellViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return spellList.size
    }

    override fun onBindViewHolder(holder: SpellViewHolder, position: Int) {
        val spellItem = spellList[position]
        holder.bind(spellItem)
    }
}
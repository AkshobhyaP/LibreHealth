package com.akshobhya.librehealth.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;

import com.akshobhya.librehealth.Adapter.FirstAidAdapter;
import com.akshobhya.librehealth.R;

import java.util.ArrayList;

public class FirstaidActivity extends AppCompatActivity {

    RecyclerView rv;
    Context context;
    ArrayList<String> list_name = new ArrayList<String>();
    ArrayList<String> list_details = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_firstaid);
        context = this;
        get_data();
        rv = findViewById(R.id.rv_firstaid);
        rv.setLayoutManager(new LinearLayoutManager(context));
        FirstAidAdapter adapter = new FirstAidAdapter(context, list_name, list_details);
        rv.setAdapter(adapter);
    }

    void get_data() {
        list_name.add("Burns and Scalds");
        list_details.add("• First-degree burns: These  affect just the outer layer of the skin. May appear reddish,swollen and painful.\n" +
                "• Second-degree burns:These affect the outer and second layer of skin. May appear bright red, swollen, blistery and be in severe pain.\n" +
                "• Third-degree burns: These involve all the layers of skin and underlying tissues. May appear like a wound that is charred, black, white, leathery or waxy. The child might not be in pain because the nerves on the skin are damaged.\n" +
                "\n" +
                "If your little one gets a burn:\n" +
                "1. First ensure that the area is safe and there is no risk of further injury to your baby or yourself.\n" +
                "2. If the burn or scald is over the clothing, remove the clothing immediately. If it seems stuck to the skin, leave it for the doctor to do it in hospital.\n" +
                "3. If a chemical substance has burnt the skin, flush the area with cool water for five minutes first before removing  any clothes to prevent the chemical from being exposed to other areas of the body.\n" +
                "4. Treat the burn under running water for around 20 minutes immediately. Try and cool  the burn and not the whole body of the child. If the burn is over a large area, stop cooling after 20 minutes to prevent hypothermia that can happen quickly in children.\n" +
                "5. Cover the burn with a loose, light, non-sticky dressing such as a clean wet cloth and seek immediate medical attention.\n" +
                "6. Don’t apply ice, lotions, jelly’s, oil, butter, creams or powder to the burn, they can make the damage worse.\n" +
                "7. If it is an electrical burn, disconnect the power or separate your baby from the power by using a non-metallic object e.g. wooden spoon or book. Avoid using your bare hands to avoid electrocuting yourself then treat the injury.");
        list_name.add("Cuts and Scrapes");
        list_details.add("If your child cuts him/herself or falls down and gets a scrape, you can do the following:\n" +
                "• If there is bleeding, press firmly over the site with a clean cloth until it stops at least within 15 minutes.\n" +
                "• Clean under lukewarm running water and pat dry.\n" +
                "• If the wound is dirty, rinse with water and lather with soap.\n" +
                "• If the skin is broken, apply an antiseptic cream and cover with a bandage or gauze.\n" +
                "• If you cannot control the bleeding, seek immediate medical attention in the nearest health centre.\n" +
                "• An animal bite that has caused a deep cut has to be attended to by a doctor.\n" +
                "• If the wound after a few days appears to be forming or draining pus or becomes swollen, see a doctor immediately.\n" +
                "\n" +
                "Splinter, glass or insect sting\n" +
                "• Use soap or water to wash the around the splinter.\n" +
                "• Clean your tweezers with spirit and slowly pull the splinter out.\n" +
                "• Wash the skin again .\n" +
                "• If the splinter is hard to remove, leave it for a day and see if it will come out on its own.\n" +
                "• If it was a sting, gently scrape the skin with your fingernail or an ATM card to remove it without breaking it. Watch out for signs of bee sting allergy e.g. wheezing, difficulty in breathing, hoarse voice, hives, etc. and seek immediate medical attention.");
        list_name.add("Nose Bleeding");
        list_details.add(" Have your child sit upright; avoid tilting the head back.\n" +
                "• Loosen any tight clothing around the neck.\n" +
                "• Pinch the lower end of the nose close to the nostrils and have the child lean forward while you apply pressure continuously for 5 to 10 minutes.\n" +
                "• If the nosebleed was caused by an injury, reduce any swelling to the nose by holding an ice-pack against the nose. If the bleeding persists, then seek medical attention.");
        list_name.add("Common Ailments");
        list_details.add("Babies can get colds just like the rest of us. A cold is caused by a virus and usually results in mild symptoms in your baby (stuffy or runny nose, mild fever, and mild cough). For mild colds, there is usually no special treatment. However, if the nose becomes too runny or stuffy, it may make it hard for a young baby to nurse or drink from a bottle. Since a baby can’t blow her nose, you may have to clear out mucus by suctioning with a bulb syringe. Also talk to your doctor about using warm water or saline nose drops to loosen up dried mucus before suctioning. Don’t give your baby any medications without checking first with your doctor.\n" +
                "\n" +
                "Eye injuries \n" +
                "\n" +
                "All eye injuries (common ones include bruising around the eye, scratches on the cornea) should be evaluated by a doctor. If an irritating substance is splashed into the eye, flush it with water for at least 15 minutes and seek medical care. Don’t rub the eye, apply medication, or try to remove an embedded object yourself.\n" +
                "\n" +
                "Prevention is always better. Follow these guidelines:\n" +
                "• Wash your hands with soap and warm water before touching your baby, and ask others to do the same.\n" +
                "• Stay home. Keep your baby at home as much as possible. Especially avoid taking your baby to crowded locations, such as shopping malls, restaurants, and church.\n" +
                "• Keep sick people away. Keep people who have colds away from your baby and those feeling ill should refrain from kissing the baby.\n" +
                "• Don’t smoke or allow others to smoke near your baby. Exposure to tobacco smoke can increase the severity of viruses and infections.\n" +
                "\n" +
                "See a doctor immediately if you notice any of the following:\n" +
                "\n" +
                "• Reddened or firm skin around the umbilical site or skin that has pus or a foul smell.\n" +
                "• Redness, swelling, tenderness, pus, or bleeding at the circumcision site.\n" +
                "• Vomiting more than occasionally or vomit that is green or bloody.\n" +
                "• Thrush white or greyish-white, slightly elevated patches resembling curds of milk on the tongue, roof of the mouth, lips, or throat.\n" +
                "• Breathing faster than 60 breaths per minute.\n" +
                "• Wheezing or coughing.\n" +
                "• Lethargy, or an overall change in activity or behaviour.");
        list_name.add("Fever");
        list_details.add("Causes Of Fever In Children\n" +
                "• Bacterial Infections\n" +
                "• Viral Infections\n" +
                "• Certain Medications\n" +
                "• Heat Illness\n" +
                "\n" +
                "Symptoms Of Fever In Children\n" +
                "• Irritability and fussiness\n" +
                "• Lethargy\n" +
                "• Being too quiet\n" +
                "• Feel warm or hot to touch\n" +
                "• Not feeding normally\n" +
                "• Prolonged and inconsolable crying\n" +
                "• Breathing rapidly\n" +
                "• Changes in sleeping or eating habits\n" +
                "\n" +
                "For children less than 3 months (90 days) old, take an armpit temperature. It’s a safe and easy method that is adequate for screening. This is how to take armpit temperatures:\n" +
                "• Make sure your baby’s armpit is dry.\n" +
                "• Put the tip of the thermometer in your baby’s armpit, directly against her skin (skin should completely surround the tip of the thermometer).\n" +
                "• Close your baby’s armpit by holding her elbow against her chest.\n" +
                "• Follow the directions on your thermometer to determine how long you should hold the thermometer in place before reading it.\n" +
                "\n" +
                "Your child has fever if his temperature is:\n" +
                "• Higher than 37.8 degrees C measured orally or in the ear.\n" +
                "• Higher than 37.5 degrees C measured under the arm.\n" +
                "\n" +
                "Handling Fever in Babies\n" +
                "• Increase your child’s intake of water and other fluids. It is very important to keep his/her body well hydrated. If he/she refuses to have too many fluids at one time, give them at frequent intervals.\n" +
                "• Let your child get proper rest and sleep. This will allow his/her body rejuvenate and recover completely.\n" +
                "• As long as the temperature is at or below 38.5 degrees C, do not give antipyretic medication to your child, unless he/she is 3 months or younger.\n" +
                "• Sponge your child with a wet compress as many times as you can. When it is not possible, keep a wet compress on his/her forehead, temples and feet, using lukewarm water. Please do not use rubbing alcohol.\n" +
                "• Do not put too many clothes on your child. Dress him/her lightly and make sure that the clothes are not too tight.\n" +
                "• See the doctor if your child is 3 months or younger and has a temperature of 38.5 degrees C or higher.");
        list_name.add("Choking");
        list_details.add("• Hold your baby so that he is lying face down along your forearm with his head lower than his bottom and his back and head supported.\n" +
                "• Use the heel of your hand to give up to five blows between your baby’s shoulder blades. Effective back blows cure the majority of choking incidents.\n" +
                "• Check your baby’s mouth and remove any obvious obstructions. Do not use your finger to sweep inside his mouth. This could push the obstruction further into his throat.\n" +
                "\n" +
                "Give five chest thrusts\n" +
                "• If your baby is still unable to breathe, turn him onto his back and give up to five chest thrusts. Use two fingertips to push inwards and upwards (towards his head against his breastbone, one finger’s width below his nipple line). Try to dislodge the object with each thrust.\n" +
                "• Check your baby’s mouth after each thrust and remove the obstruction if you can reach it. Continue giving your baby back blows and chest thrusts until help arrives.\n" +
                "• Even if your baby seems to be fully recovered from the choking episode, take him to your doctor that day.\n" +
                "• If your baby is unconscious try to get a response by calling his name and tapping gently on the sole of his foot. If your baby is unconscious but breathing normally, hold him on his side, head tilted, as if you were cuddling him, with his head lower than his tummy. If your baby is unconscious and he is having trouble breathing use the following procedure:\n" +
                "\n" +
                "Open the airway\n" +
                "\n" +
                "• Kneel at a right angle to your baby’s chest. Place one hand on his forehead and gently tip his head back. Then using your other hand use one finger to lift his chin.\n" +
                "• With one hand on his forehead and the other supporting the back of his neck, gently tilt his head back to open the airway. In some cases, this may be enough to help breathing resume.\n" +
                "• Take a quick look at your baby to remove any visible obstructions from his mouth and nose. Look, listen and feel for normal breathing as shown. Allow up to 10 seconds for this.\n" +
                "• If he’s not breathing begin CPR (a combination of chest compressions and rescue breaths) as you call an ambulance or rush him the nearest health centre.\n" +
                "\n" +
                "Give five rescue breaths\n" +
                "• Open your baby’s airway.\n" +
                "• Seal your lips around your baby’s mouth and nose.\n" +
                "• Blow steadily into his lungs, looking along your baby’s chest as you breathe. Fill your cheeks with air and use this amount each time.\n" +
                "• As the chest rises, stop blowing and allow it to rise.\n" +
                "• Repeat this five times.\n" +
                "\n" +
                "Give 30 chest compressions:\n" +
                "• Ensure that your baby is on a firm surface.\n" +
                "• Place two fingers in the centre of your baby’s chest. Imagine a line between your baby’s nipples. Find the middle of that line and measure about one finger’s width below that point. Now position two fingers of one hand on that spot.\n" +
                "• Press down sharply to a third of the depth of the chest.\n" +
                "• Press 30 times, at a rate of 100 compressions per minute.\n" +
                "• After 30 compressions, give two rescue breaths.\n" +
                "• Continue resuscitation (30 compressions to two rescue breaths) without stopping until help arrives or you reach the nearest health centre.\n" +
                "\n" +
                "CHOKING ON MUCUS OR MILK\n" +
                "•    If your baby begins to choke on mucus or milk, turn him on his side with his head slightly lower than his body. If necessary, gently assist him in clearing any visible fluid from his mouth or nose with a cloth or your fingers. If this method doesn’t work, you may need to use a bulb syringe.\n" +
                "\n" +
                "USING A BULB SYRINGE\n" +
                "• In the mouth: Turn your baby on his side with his head slightly lower than his body. Press in the bulb before placing it in the baby’s mouth. As you suction out the mucus or milk, be careful not to catch the delicate mucous membranes inside the cheeks or the back of the throat. Remove the bulb, and squirt the contents into a cloth.\n" +
                "• In the nose: Suction mucus from the nostrils in a similar way, inserting only the tip of the bulb syringe. Be extremely careful when you do this. Suctioning the mouth or nose too vigorously, too often, or for too long can dry and irritate delicate tissues and cause trauma or irritation to the mouth or nose.");
    }
}

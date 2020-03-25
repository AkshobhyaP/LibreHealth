package com.akshobhya.librehealth.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;

import com.akshobhya.librehealth.Adapter.FirstAidAdapter;
import com.akshobhya.librehealth.R;

import java.util.ArrayList;

public class GrowthActivity extends AppCompatActivity {

    RecyclerView rv;
    Context context;
    ArrayList<String> list_name = new ArrayList<String>();
    ArrayList<String> list_details = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_growth);
        context = this;
        get_data();
        rv = findViewById(R.id.rv_growth);
        rv.setLayoutManager(new LinearLayoutManager(context));
        FirstAidAdapter adapter = new FirstAidAdapter(context, list_name, list_details);
        rv.setAdapter(adapter);
    }

    void get_data() {
        list_name.add("Birth to 1 month");
        list_details.add("Mouthing reflexes: These reflexes are important for baby's survival, helping them find the source of food. The sucking and swallowing reflexes are most important. A baby will automatically begin to suck when their mouth or lips are touched. The rooting reflex is when the baby turns his head toward your hand if their cheek is touched. This helps baby find the nipple for feeding. This response is called the rooting reflex and begins to fade around 4 months of age.\n" +
                "Startle (Moro) reflex: The startle reflex occurs when a baby hears a loud noise or when he falls backward, his arms and legs extend away from his body. This reflex is most noticeable during the first month and usually fades by 2 or 3 months.\n" +
                "Grasp reflex: A baby will grasp a finger or object when it is placed in the palm of her hand. This reflex is strongest during the first 2 months and usually fades by 5-6 months.\n" +
                "Stepping reflex: Even though baby cannot support his own weight, if his feet are placed on a flat surface, he will begin to step one foot in front of the other. The stepping reflex usually disappears by 2 months.\n" +
                "\nBy the end of the first month of life, most babies may display the following:\n" +
                "\n" +
                "\u2022 Raises head when on stomach\n" +
                "\u2022 Keeps hands in tight fists\n" +
                "\u2022 Focuses 8-12 inches away, looks at objects and faces, and prefers the human face over other patterns. Black and white objects are preferred over those of various colors.\n" +
                "\u2022 Shows a behavioral response when hearing a noise (such as eye blinking, acting startled, change in movements or breathing rate)");
        list_name.add("1 to 3 months");
        list_details.add(
                "Motor Skills\n" +
                        "\n" +
                        "\u2022 Supports head and upper body when on stomach\n" +
                        "\u2022 Stretches out legs and kick when on stomach or back\n" +
                        "\u2022 Opens and shut hands\n" +
                        "\u2022 Brings hands to mouth\n" +
                        "\u2022 Grabs and shakes hand toys\n" +
                        "\u2022 Swipes and bats at dangling objects\n" +
                        "\u2022 Pushes down legs when on a flat surface\n" +
                        "\u2022 Follows moving objects with eyes\n" +
                        "\u2022 Turning their head to face the stimulus\n" +
                        "\nLanguage Skills\n" +
                        "\n" +
                        "\u2022 Makes cooing sounds\n" +
                        "\nSocial/Emotional Skills\n" +
                        "\n" +
                        "\u2022 Smiles at familiar faces\n" +
                        "\u2022 Enjoys playing with other people");
        list_name.add("4 to 7 months");
        list_details.add(
                "Motor Skills\n" +
                        "\n" +
                        "\u2022 Rolls over both ways (stomach to back, back to stomach)\n" +
                        "\u2022 Sits up with, and then without, support of his hands\n" +
                        "\u2022 Reaches for object with one hand using the raking grasp\n" +
                        "\u2022 Transfers objects from hand to hand\n" +
                        "\u2022 Supports whole weight when on legs and held upright\n" +
                        "\u2022 Explores objects with hands and mouth\n" +
                        "\u2022 Explores objects by banging and shaking\n" +
                        "\n Language Skills\n" +
                        "\n" +
                        "\u2022 Laughs\n" +
                        "\u2022 Babbles consonants (like ba-ba-ba-ba-ba)\n" +
                        "\nSocial/Emotional Skills\n" +
                        "\n" +
                        "\u2022 Distinguishes emotions by tone of voice\n" +
                        "\u2022 Finds partially hidden objects");
        list_name.add("8 to 12 months");
        list_details.add(
                "Motor Skills\n" +
                        "\n" +
                        "\u2022 Gets in and out of a sitting position independently\n" +
                        "\u2022 Gets on hands-and-knees position and crawls\n" +
                        "\u2022 Pulls self up to standing position, walks holding on to furniture, stands without support and, eventually, takes a few steps without support and begins to walk\n" +
                        "\u2022 Uses pincer grasp (thumb and first finger)\n" +
                        "\u2022 Places objects into container and takes them out of container\n" +
                        "\u2022 Begins to do more functional activities, such as hold a spoon or turn pages in a book\n" +
                        "\nLanguage Skills\n" +
                        "\n" +
                        "\u2022 Says \"mama\" and \"dada\" and uses these terms specifically referring to a parent\n" +
                        "\u2022 Uses exclamations such as \"oh-oh!\"\n" +
                        "\u2022 Tries to imitate words and may say first word\n" +
                        "\u2022 Uses simple gestures, such as shaking head for \"no\" or waving for \"bye-bye\"\n" +
                        "\u2022 Plays interactive gesture games, such as pat-a-cake and peek-a-boo\n" +
                        "\nSocial/Emotional Skills\n" +
                        "\n" +
                        "\u2022 Easily finds hidden objects\n" +
                        "\u2022 Uses objects correctly such as holding phone up to ear or drinking from a cup\n" +
                        "\u2022 Is shy around strangers\n" +
                        "\u2022 Cries when mom or dad leaves");

    }
}

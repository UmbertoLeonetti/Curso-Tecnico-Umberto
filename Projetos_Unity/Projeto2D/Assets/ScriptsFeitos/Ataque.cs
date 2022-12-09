using System.Collections;
using System.Collections.Generic;
using UnityEngine;
using TMPro;

public class Ataque : MonoBehaviour
{

    [SerializeField] private LayerMask _enemyLayer;

    public Transform Transform;

    private Animator _animator;
    private Collider2D hitbox;
    private bool _basciAttackPressed;
    private bool _isAttacking;

    public float _radius;
    public int _power;

    private void Start()
    {
        _animator = GetComponent<Animator>();
    }

    private void Update()
    {
      
    }
    private void FixedUpdate()
    {
        if (_basciAttackPressed)
        {
            _basciAttackPressed = false;

            if (!_isAttacking)
            {
                _isAttacking = true;
                Damage();
                _animator.SetBool("Ataque", true);
                Invoke("StopAttack", 0.5f);
            }
        }
    }


    private void StopAttack()
    {
        _animator.SetBool("Ataque", false);
        _isAttacking = false;
    }

    private void Damage()
    {
        if (!hitbox)
            return;


        hitbox.gameObject.GetComponent<Saúde>().TakeDamage(_power);


    }

    public void ataque()
    {
        _animator.SetBool("Ataque", false);
    }

}

